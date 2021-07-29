
import { Injectable } from "@angular/core";
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../environments/environment';
import {Todo} from './todo';


const API_URL = `${environment.apiUrl}`;
// @ts-ignore
@Injectable({
  providedIn: 'root'
})
export class TodoService {
  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Todo[]> {
    return this.http.get<Todo[]>(API_URL + '/todo');
  }

  save(t): Observable<Todo> {
    return this.http.post<Todo>(API_URL + '/todo', t);
  }

  findById(id: number): Observable<Todo> {
    return this.http.get<Todo>(`${API_URL}/todo/${id}`);
  }

  update(id: number, t: Todo): Observable<Todo> {
    return this.http.put<Todo>(`${API_URL}/todo/${id}`, t);
  }

  delete(id: number): Observable<Todo> {
    return this.http.delete<Todo>(`${API_URL}/todo/${id}`);
  }

}
