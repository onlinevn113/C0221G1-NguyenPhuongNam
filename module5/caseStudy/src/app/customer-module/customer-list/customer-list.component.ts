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
  page = 1;
  idDelete: number;
  nameDelete: string;
  customers: Customer[] = [];
  nameSearch = '';
  addressSearch = '';
  customerTypes: CustomerType[] = [];
  // tslint:disable-next-line:max-line-length
  validMsg: { birthday: { msg: string; type: string }[]; customerType: { msg: string; type: string }[]; addresss: ({ msg: string; type: string } | { msg: string; type: string })[]; idCard: ({ msg: string; type: string } | { msg: string; type: string })[]; name: ({ msg: string; type: string } | { msg: string; type: string })[]; phonee: ({ msg: string; type: string } | { msg: string; type: string })[]; customer_code: ({ msg: string; type: string } | { msg: string; type: string })[]; email: ({ msg: string; type: string } | { msg: string; type: string })[] };
  editForm;

  createForm = new FormGroup({
    code: new FormControl('', [Validators.required, Validators.pattern('^KH-\\d{3}$')]),
    customerType: new FormControl('', [Validators.required]),
    name: new FormControl('', [Validators.required, Validators.minLength(5)]),
    birthday: new FormControl('', [Validators.required]),
    idCard: new FormControl('', [Validators.required, Validators.pattern(/^[0-9]{9}$/)]),
    phone: new FormControl('', [Validators.required, Validators.pattern(/^[0-9]{9}$/)]),
    email: new FormControl('', [Validators.required, Validators.email]),
    address: new FormControl('', [Validators.required, Validators.minLength(5)]),
  });

  // tslint:disable-next-line:max-line-length
  constructor(private loadCss?: LoadCssService, private cs?: CustomerService, private router?: Router) {
    loadCss.loadCss('https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css');
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

  sendIdDelete(id: number) {
    this.idDelete = id;
    this.cs.findById(id).subscribe(c => {
      this.nameDelete = c.name;
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
      text: 'Do you want to delete ' + name,
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
          'success'
        );
      } else if (
        /* Read more about handling dismissals below */
        result.dismiss === Swal.DismissReason.cancel
      ) {
        swalWithBootstrapButtons.fire(
          'Cancelled',
          '',
          'error'
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


  getALlTypeCustomer() {
    this.cs.getAllCustomerType().subscribe(tc => {
      this.customerTypes = tc;
    });
  }

  getValidate(attribute: string, valid): boolean {
    return this.createForm.get(attribute)?.hasError(valid.type) &&
      (this.createForm.get(attribute)?.touched || this.createForm.get(attribute)?.dirty);
  }

  clearFormCreate() {
    this.createForm.reset();

  }

  clearFormEdit() {
    this.editForm.reset();
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
    return this.cs.findById(id).subscribe(c => {
      console.log(c.name);
      this.editForm = new FormGroup({
        id: new FormControl(c.id),
        code: new FormControl(c.code, [Validators.required, Validators.pattern('KH-\\d{3}')]),
        customerType: new FormControl(c.customerType),
        name: new FormControl(c.name, [Validators.required, Validators.minLength(5)]),
        birthday: new FormControl(c.birthday, [Validators.required]),
        idCard: new FormControl(c.idCard, [Validators.required, Validators.pattern('[0-9]{9}')]),
        phone: new FormControl(c.phone, [Validators.required, Validators.pattern('[0-9]{10}')]),
        email: new FormControl(c.email, [Validators.required, Validators.email]),
        address: new FormControl(c.address, [Validators.required, Validators.minLength(5)]),
      });
    });
  }

  sendIdEdit(id: number) {
    this.validMsg = new ValidateMsg().msgArr();
    this.showFormEdit(id);
    // tslint:disable-next-line:only-arrow-functions
    setTimeout(function() {
      document.getElementById('showEditModal').click();
    }, 1);
  }

  editCustomer() {
    const customer = this.editForm.value;
    this.cs.update(customer.id, customer).subscribe(() => {
      alert('edit is success');
    });
  }
}
