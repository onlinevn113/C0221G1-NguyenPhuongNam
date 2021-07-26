import { Component, OnInit } from '@angular/core';
import {CustomerType} from '../../model/customer-type';
import {FormGroup} from '@angular/forms';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.scss']
})
export class CustomerEditComponent implements OnInit {
  listType: CustomerType[] = [];
  form!: FormGroup;
  editId!: number;
  constructor() { }

  ngOnInit(): void {
  }

}
