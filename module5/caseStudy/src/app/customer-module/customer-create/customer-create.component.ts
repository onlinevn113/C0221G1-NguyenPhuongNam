import {Component, OnInit} from '@angular/core';
import {CustomerType} from '../../model/customer-type';
import {FormControl, FormGroup, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import {CustomerService} from '../../service/customer.service';
import {Router} from '@angular/router';
import {LoadCssService} from '../../bootstrap/load-css.service';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.scss']
})
export class CustomerCreateComponent implements OnInit {
  customerTypes: CustomerType[] = [];

  validMsg = {
    email: [
      {type: 'required', msg: 'Please Input'},
      {type: 'email', msg: 'Please Input invalid'},
    ],
    // customer_code: [
    //   {type: 'required', msg: 'Please Input'},
    //   {type: 'pattern', msg: 'Please Input invalid'},
    // ],
    // customerType: [
    //   {type: 'required', msg: 'Please Input'}
    //
    // ],
    // name: [
    //   {type: 'required', msg: 'Please Input'},
    //   {type: 'pattern', msg: 'Please Input invalid'},
    // ],
    // birthday: [
    //   {type: 'required', msg: 'Please Input'},
    //   {type: 'pattern', msg: 'Please Input invalid'},
    // ],
    // phone: [
    //   {type: 'required', msg: 'Please Input'},
    //   {type: 'pattern', msg: 'Please Input invalid'},
    // ],
    //
    // address: [
    //   {type: 'required', msg: 'Please Input'},
    //   {type: 'pattern', msg: 'Please Input invalid'},
    // ],
    // idCard: [
    //   {type: 'required', msg: 'Please Input'},
    //   {type: 'pattern', msg: 'Please Input invalid'},
    // ],
  };

  createForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    // code: new FormControl('', [Validators.required, Validators.pattern('(KH-)\\d{4}')]),
    // customerType: new FormControl('', Validators.required),
    // name: new FormControl('', [Validators.required, Validators.minLength(5)]),
    // birthday: new FormControl('', [Validators.required]),
    // phone: new FormControl('', [Validators.required, Validators.pattern('^[0-9]{10}$')]),
    // address: new FormControl('', [Validators.required, Validators.minLength(5)]),
    // idCard: new FormControl('', [Validators.required, Validators.pattern('^[0-9]{10}$')]),
  });


  constructor(private cs: CustomerService,
              private router: Router,
              private loadCss: LoadCssService) {
    loadCss.loadCss('https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css');
    // loadCss.loadCss('https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css');
    loadCss.loadScript('assets/script/input.js');
  }

  ngOnInit(): void {
    this.getALlTypeCustomer();
  }


  getALlTypeCustomer() {
    this.cs.getAllCustomerType().subscribe(tc => {
      this.customerTypes = tc;
    });
  }
  getValidate(attribute: string, valid): boolean{
    return this.createForm.get(attribute)?.hasError(valid.type) &&
      (this.createForm.get(attribute)?.touched || this.createForm.get(attribute)?.dirty);
  }
  saveCustomer() {
    const customer = this.createForm.value;
    this.cs.save(customer).subscribe(() => {
      this.createForm.reset();
      alert('Create is success');
      this.router.navigateByUrl('/customer/list');
    }, error => {
      console.log(error);
    });
  }
}
