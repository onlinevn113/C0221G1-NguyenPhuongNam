import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {BenhNhan} from '../model/benh_vien/benh-nhan';

const API_URL= 'http://localhost:3000';
@Injectable({
  providedIn: 'root'
})
export class BenhNhanService {
  constructor(private http: HttpClient) {
  }

  getAll(): Observable<BenhNhan[]> {
    return this.http.get<BenhNhan[]>(API_URL + '/benhNhans');
  }

  findById(id: number): Observable<BenhNhan> {
    return this.http.get<BenhNhan>(`${API_URL}/benhNhans/${id}`);
  }

  update(id: number, benhNhan: BenhNhan): Observable<BenhNhan> {
    return this.http.put<BenhNhan>(`${API_URL}/benhNhans/${id}`, benhNhan);
  }

  delete(id: number): Observable<BenhNhan> {
    return this.http.delete<BenhNhan>(`${API_URL}/benhNhans/${id}`);
  }

}
