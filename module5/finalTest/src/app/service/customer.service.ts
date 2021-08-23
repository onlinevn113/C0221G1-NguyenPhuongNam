import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {CustomerType} from '../model/customer/customer-type';

import {Customer} from '../model/customer/customer';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';

const API_URL= environment.apiUrl;
@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) {
  }

  getAllCustomerType(): Observable<CustomerType[]> {
    return this.http.get<CustomerType[]>(API_URL + '/customer/customer-type');
  }

  getAll(): Observable<Customer[]> {
    return this.http.get<Customer[]>(API_URL + '/customer');
  }

  save(customer): Observable<Customer> {
    return this.http.post<Customer>(API_URL + '/customer/create', customer);
  }

  findById(id: number): Observable<Customer> {
    return this.http.get<Customer>(`${API_URL}/customer/${id}`);
  }

  update(id: number, customer: Customer): Observable<Customer> {
    return this.http.put<Customer>(`${API_URL}/customer/edit/${id}`, customer);
  }

  delete(id: number): Observable<Customer> {
    return this.http.delete<Customer>(`${API_URL}/customer/delete/${id}`);
  }

  search(name: string, email: string): Observable<Customer[]> {
    return this.http.get<Customer[]>(API_URL + '/customer?name_like=' + name + '&' + 'email_like=' + email);
  }
}
