import {Component, OnInit} from '@angular/core';
import {CustomerType} from '../../model/customer-type';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {CustomerService} from '../../service/customer.service';
import {Customer} from '../../model/customer';


@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.scss']
})
export class CustomerEditComponent implements OnInit {
  customerTypes: CustomerType[] = [];
  editForm!: FormGroup;
  editId!: number;
  customer!: Customer;


   constructor(private fb: FormBuilder, private cs: CustomerService, private activatedRoute: ActivatedRoute, private route: Router) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.editId = +paramMap.get('id');
    });
    this.getCustomerType();
    this.getCustomer();
  }

  getCustomerType() {
    this.cs.getAllCustomerType().subscribe(type => {
      this.customerTypes = type;
      console.log(this.customerTypes);
    }, error => {
      console.log('get ' + error + ' at getListType  ');
    });
  }

  getCustomer() {
    return this.cs.findById(this.editId).subscribe(customer => {
      this.editForm = new FormGroup({
        id: new FormControl(customer.id, [Validators.required, Validators.min(0)]),
        code: new FormControl(customer.code, [Validators.required, Validators.pattern('KH-\\d{3}')]),
        customerType: new FormControl(customer.customerType, [Validators.required]),
        name: new FormControl(customer.name, [Validators.required, Validators.minLength(5)]),
        birthday: new FormControl(customer.birthday, [Validators.required]),
        idCard: new FormControl(customer.idCard, [Validators.required, Validators.pattern('\\d{9}')]),
        phone: new FormControl(customer.phone, [Validators.required, Validators.pattern('(090)\\d{7}')]),
        email: new FormControl(customer.email, [Validators.required, Validators.email]),
        address: new FormControl(customer.address, [Validators.required, Validators.minLength(5)]),
      });
    });
  }
  editCustomer() {
    const customer = this.editForm.value;
    this.cs.update(this.editId, customer).subscribe(() => {
      // this.customerForm.reset();
      this.route.navigateByUrl('customer/list');
    });
  }
}
