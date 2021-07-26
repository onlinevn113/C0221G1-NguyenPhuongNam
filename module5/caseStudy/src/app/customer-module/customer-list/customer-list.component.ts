import {Component, OnInit} from '@angular/core';
import {Customer} from '../../model/customer';

import {LoadCssService} from '../../bootstrap/load-css.service';
import {CustomerService} from '../../service/customer.service';





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
  customer: Customer;
  nameSearch = '';
  addressSearch = '';
  constructor(private loadCss: LoadCssService, private cs: CustomerService) {
    loadCss.loadCss('https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css');
    loadCss.loadScript('https://code.jquery.com/jquery-3.5.1.slim.min.js');
    loadCss.loadScript('https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js');
    loadCss.loadScript('https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js');

  }
  ngOnInit(): void {
    this.getAll();
  }
  getAll() {
    this.cs.getAll().subscribe(customers => {
      this.customers = customers;
    });
  }
  sendIdDelete(id: number) {
    this.idDelete = id;
    this.cs.findById(id).subscribe(c => {
      this.customer = c;
      this.nameDelete = c.name;
    });
  }
  deleteCustomer() {
    console.log(this.idDelete);
    this.cs.delete(this.idDelete).subscribe(() => {
      this.getAll();
    });
  }
  search() {
    console.log(this.nameSearch);
    this.cs.search(this.nameSearch , this.addressSearch).subscribe(c => {
      this.customers = c;
      this.page = 1;
    });
  }
}
