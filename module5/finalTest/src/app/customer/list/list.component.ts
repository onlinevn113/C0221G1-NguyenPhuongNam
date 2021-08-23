import {Component, OnInit} from '@angular/core';
import {Customer} from '../../model/customer/customer';
import {CustomerService} from '../../service/customer.service';
import Swal from 'sweetalert2';
import {LoadCssService} from '../../bootstrap/load-css.service';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerType} from '../../model/customer/customer-type';
import {ExportService} from '../../service/export.service';


@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {
  customers: Customer[] = [];
  page = 1;
  nameSearch = '';
  emailSearch = '';
  customer: Customer;
  customerTypes: CustomerType[];
  createForm: FormGroup = new FormGroup({
    name: new FormControl('', Validators.required),
    birthday: new FormControl('', Validators.required),
    gender: new FormControl('', Validators.required),
    email: new FormControl('', [Validators.required, Validators.email]),
    customerType: new FormControl('', Validators.required),
    localDateTime: new FormControl(''),
    dateTime: new FormControl('')
  });
  msg = {
    customerType: [
      {type: 'required', msg: 'Please select'}
    ],
    name: [
      {type: 'required', msg: 'Please Input'},
      {type: 'minLength', msg: 'Please Input >5 letter'}
    ],
    birthday: [
      {type: 'required', msg: 'Please Input'}
    ],
    email: [
      {type: 'required', msg: 'Please Input'},
      {type: 'email', msg: 'Please Input invalid'},
    ],
    gender: [
      {type: 'required', msg: 'Please Input'},
    ]
  };

  constructor(private sv: CustomerService, private load: LoadCssService, private exportService: ExportService) {
    document.getElementById('b34')?.parentNode.removeChild(document.getElementById('b34'));
    load.loadCss('https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css');
    // loadCss.loadCss('https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css');
    load.loadCss('https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css');
    load.loadScript('assets/side-nav.js');
    load.loadScript('https://code.jquery.com/jquery-3.5.1.slim.min.js');
    load.loadScript('https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js');
    load.loadScript('https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js');
  }

  ngOnInit(): void {
    this.getAll();
    this.getAllCustomerType();
  }

  getAll() {
    this.sv.getAll().subscribe(c => {
      this.customers = c;
    });
  }

  getAllCustomerType() {
    this.sv.getAllCustomerType().subscribe(ct => {
      this.customerTypes = ct;
    });
  }

  delete(id: number) {
    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: 'btn btn-success',
        cancelButton: 'btn btn-danger'
      },
      buttonsStyling: false
    });
    swalWithBootstrapButtons.fire({
      title: 'Are you sure?',
      text: 'You won\'t be able to revert this!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, cancel!',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {
        this.sv.delete(id).subscribe(() => {
          this.getAll();
        });
        swalWithBootstrapButtons.fire(
          'Deleted!',
          'Your file has been deleted.',
          'success'
        );
      } else if (
        /* Read more about handling dismissals below */
        result.dismiss === Swal.DismissReason.cancel
      ) {
        swalWithBootstrapButtons.fire(
          'Cancelled',
          'Your imaginary file is safe :)',
          'error'
        );
      }
    });
  }

  exposrt() {
    this.exportService.exportExcel(this.customers, 'customers');
  }

  search() {
    this.sv.search(this.nameSearch, this.emailSearch).subscribe(c => {
      this.customers = c;
      this.page = 1;
    });
  }

  create() {
    this.customer = this.createForm.value;
    this.sv.save(this.customer).subscribe(() => {
      alert('Create success');
    });
  }

  getValidateCreate(attribute: string, valid): boolean {
    return this.createForm.get(attribute)?.hasError(valid.type) &&
      (this.createForm.get(attribute)?.touched || this.createForm.get(attribute)?.dirty);
  }

  clearFormCreate() {
    this.createForm.reset();
  }
}
