import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {CustomerType} from '../model/customer/customer-type';

import {Customer} from '../model/customer/customer';
import {HttpClient} from '@angular/common/http';

const API_URL= 'http://localhost:3000';
@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) {
  }

  getAllCustomerType(): Observable<CustomerType[]> {
    return this.http.get<CustomerType[]>(API_URL + '/customerTypes');
  }

  getAll(): Observable<Customer[]> {
    return this.http.get<Customer[]>(API_URL + '/customers');
  }

  save(customer): Observable<Customer> {
    return this.http.post<Customer>(API_URL + '/customers', customer);
  }

  findById(id: number): Observable<Customer> {
    return this.http.get<Customer>(`${API_URL}/customers/${id}`);
  }

  update(id: number, customer: Customer): Observable<Customer> {
    return this.http.put<Customer>(`${API_URL}/customers/${id}`, customer);
  }

  delete(id: number): Observable<Customer> {
    return this.http.delete<Customer>(`${API_URL}/customers/${id}`);
  }

  search(name: string, email: string): Observable<Customer[]> {
    return this.http.get<Customer[]>(API_URL + '/customers?name_like=' + name + '&' + 'email_like=' + email);
  }
}
