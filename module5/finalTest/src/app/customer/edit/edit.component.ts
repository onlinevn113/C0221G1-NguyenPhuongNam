import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Customer} from '../../model/customer/customer';
import {CustomerService} from '../../service/customer.service';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerType} from '../../model/customer/customer-type';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.scss']
})
export class EditComponent implements OnInit {
  idEdit: number;

  customer: Customer;
  editForm: FormGroup = new FormGroup({
    name: new FormControl('', Validators.required),
    birthday: new FormControl('', Validators.required),
    gender: new FormControl('', Validators.required),
    email: new FormControl('', [Validators.required, Validators.email]),
    customerType: new FormControl('', Validators.required)
  });
  customerTypes: CustomerType[];
  msg = {
    customerType: [
      {type: 'required', msg: 'Please Input'}
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
  };

  constructor(private activatedRoute: ActivatedRoute, private sv: CustomerService, private router: Router) {
    activatedRoute.paramMap.subscribe((param) => {
      this.idEdit = +param.get('id');
      sv.findById(this.idEdit).subscribe(c => {

        this.customer = c;
        console.log(this.customer);
        this.editForm.patchValue(c);

        console.log(c);
      });
    });

    this.getAllCustomerType();
  }

  ngOnInit(): void {
  }

  getAllCustomerType() {
    this.sv.getAllCustomerType().subscribe(ct => {
        this.customerTypes = ct;
      }
    )
    ;
  }

  getValidateEdit(attribute: string, valid): boolean {
    return this.editForm.get(attribute)?.hasError(valid.type) &&
      (this.editForm.get(attribute)?.touched || this.editForm.get(attribute)?.dirty);
  }

  compareFn(c1: any, c2: any): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }

  edit() {
    this.customer = this.editForm.value;
    this.sv.update(this.idEdit, this.customer).subscribe(() => {
      alert('OK');
      this.router.navigateByUrl('customer');
    },error => {
      alert("Error")
    });
  }

}
