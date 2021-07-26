import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Customer} from '../model/customer';
const API_URL = `${environment.apiUrl}`;
@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) { }
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
    return this.http.get<Customer[]>(API_URL + '/customers?name_like=' + name + '&email_like=' + email);
  }
}
