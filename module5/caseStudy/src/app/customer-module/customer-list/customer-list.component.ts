import {Component, OnInit} from '@angular/core';
import {Customer} from '../../model/customer';
import {LoadCssService} from '../../bootstrap/load-css.service';
import {CustomerService} from '../../service/customer.service';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {CustomerType} from '../../model/customer-type';
import {ValidateMsg} from '../../service/validate-msg';


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
  isCreate = false;
  customerTypes: CustomerType[] = [];
  validMsg;

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

  search() {
    console.log(this.nameSearch);
    this.cs.search(this.nameSearch, this.addressSearch).subscribe(c => {
      this.customers = c;
      this.page = 1;
    });
  }

  create() {
    this.isCreate = true;
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

  saveCustomer() {
    const customer = this.createForm.value;
    this.cs.save(customer).subscribe(() => {
      this.createForm.reset();
      this.getAll();
      alert('Create is success');
      window.alert();

    }, error => {
      console.log(error);
    });
  }


}
