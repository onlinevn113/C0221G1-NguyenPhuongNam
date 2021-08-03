import {Component, OnInit} from '@angular/core';
import {Customer} from '../../model/customer';
import {LoadCssService} from '../../bootstrap/load-css.service';
import {CustomerService} from '../../service/customer.service';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {CustomerType} from '../../model/customer-type';
import {ValidateMsg} from '../../service/validate-msg';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.scss']
})
export class CustomerListComponent implements OnInit {
  a = '[(A-ZẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴa-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ)\\p{P}]+(\\s[(A-ZẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴa-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ)\\p{P}]+)+';
  b = '[\\w\\p{P}]+(?:\\s[\\w\\p{P}]+)+';
  isEdit = false;
  page = 1;
  idDelete: number;
  nameDelete: string;
  customers: Customer[] = [];
  nameSearch = '';
  addressSearch = '';
  customerTypes: CustomerType[] = [];
  startDate = '';
  endDate = '';
  validMsg;
  searchType = '';
  editForm = new FormGroup({
    id: new FormControl(''),
    code: new FormControl('', [Validators.required, Validators.pattern('KH-\\d{3}')]),
    customerType: new FormControl(''),
    gender: new FormControl('', [Validators.required]),
    name: new FormControl('', [Validators.required, Validators.pattern(this.a)]),
    birthday: new FormControl('', [Validators.required]),
    idCard: new FormControl('', [Validators.required, Validators.pattern('^[0-9]{9}$')]),
    phone: new FormControl('', [Validators.required, Validators.pattern('^[0-9]{9}$')]),
    email: new FormControl('', [Validators.required, Validators.email]),
    address: new FormControl('', [Validators.required, Validators.minLength(5)]),
  });

  createForm = new FormGroup({
    code: new FormControl('', [Validators.required, Validators.pattern('^KH-\\d{3}$')]),
    customerType: new FormControl('', [Validators.required]),
    gender: new FormControl('', [Validators.required]),
    name: new FormControl('', [Validators.required, Validators.pattern(this.a)]),
    birthday: new FormControl('', [Validators.required]),

    idCard: new FormControl('', [Validators.required, Validators.pattern(/^[0-9]{9}$/)]),
    phone: new FormControl('', [Validators.required, Validators.pattern(/^[0-9]{9}$/)]),
    email: new FormControl('', [Validators.required, Validators.email]),
    address: new FormControl('', [Validators.required, Validators.minLength(5)]),
  });

  constructor(private loadCss?: LoadCssService, private cs?: CustomerService, private router?: Router) {
    loadCss.loadCss('https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css');
    // loadCss.loadCss('https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css');
    loadCss.loadCss('https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css');
    loadCss.loadScript('assets/script/nav-bar.js');
    loadCss.loadScript('https://code.jquery.com/jquery-3.5.1.slim.min.js');
    loadCss.loadScript('https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js');
    loadCss.loadScript('https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js');
  }

  ngOnInit(): void {
    this.getAll();
    this.getALlTypeCustomer();
    this.validMsg = new ValidateMsg().msgArr();
  }

  getAll() {
    this.cs.getAll().subscribe(customers => {
      this.customers = customers;
    });
  }

  deleteCustomer() {
    this.cs.delete(this.idDelete).subscribe(() => {
      this.getAll();
      alert('Delete is success');
    });
  }

  deleteCustomer2(id: number, name: string) {
    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: 'btn btn-success',
        cancelButton: 'btn btn-danger'
      },
      buttonsStyling: false
    });
    swalWithBootstrapButtons.fire({
      title: 'Are you sure?',
      text: 'Do you want to delete' + ' ' + name.toUpperCase(),
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, cancel!',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {
        this.cs.delete(id).subscribe(() => {
          this.getAll();
        });
        swalWithBootstrapButtons.fire(
          'Deleted!',
          '',
          'success',
        );
      } else {
        swalWithBootstrapButtons.fire(
          'Cancelled',
          '',
          'error',
        );
      }
    });
  }

  search() {
    console.log(this.nameSearch);
    this.cs.search(this.nameSearch, this.addressSearch).subscribe(c => {
      this.customers = c;
      this.page = 1;
    });
  }

  searchBirthDate() {
    this.cs.searchBirthDate(this.startDate, this.endDate).subscribe(c => {
      this.customers = c;
      this.page = 1;
      this.startDate = '';
      this.endDate = '';
    });
  }

  searchByType() {
    this.cs.searchByType(this.searchType).subscribe(c => {
      this.customers = c;
      this.page = 1;
      // this.searchType = '';
    });
  }

  getALlTypeCustomer() {
    this.cs.getAllCustomerType().subscribe(tc => {
      this.customerTypes = tc;
    });
  }

  getValidateCreate(attribute: string, valid): boolean {
    return this.createForm.get(attribute)?.hasError(valid.type) &&
      (this.createForm.get(attribute)?.touched || this.createForm.get(attribute)?.dirty);
  }

  getValidateEdit(attribute: string, valid): boolean {
    return this.editForm.get(attribute)?.hasError(valid.type) &&
      (this.editForm.get(attribute)?.touched || this.editForm.get(attribute)?.dirty);
  }

  clearFormCreate() {
    this.createForm.reset();
  }

  changeViewEdit() {
    if (this.isEdit) {
      this.isEdit = false;
    } else {
      this.isEdit = true;
    }
  }

  saveCustomer() {
    const customer = this.createForm.value;
    this.cs.save(customer).subscribe(() => {
      this.createForm.reset();
      this.getAll();
      Swal.fire({
        icon: 'success',
        title: 'Creat is success',
      });
    }, error => {
      console.log(error);
    });
  }

  compareFn(c1: any, c2: any): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }

  showFormEdit(id: number) {
    this.isEdit = false;
    return this.cs.findById(id).subscribe(c => {
      this.editForm.patchValue(c);
    });
  }

  sendIdEdit(id: number) {
    this.validMsg = new ValidateMsg().msgArr();
    this.showFormEdit(id);
    // tslint:disable-next-line:only-arrow-functions
    setTimeout(function() {
      document.getElementById('showEditModal').click();
    }, 0);
  }

  editCustomer() {
    const customer = this.editForm.value;
    this.cs.update(customer.id, customer).subscribe(() => {
      this.getAll();
      document.getElementById('editOut').click();
      Swal.fire({
        icon: 'success',
        showConfirmButton: false,
        timer: 1000
      });
    });
  }
}
