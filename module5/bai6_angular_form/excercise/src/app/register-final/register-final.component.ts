import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";

function comparePassword(check: AbstractControl) {
  const value = check.value;
  return (value.password === value.confirmPassword) ? null : {
    passwordNotMatch: true
  };
}
@Component({
  selector: 'app-register-final',
  templateUrl: './register-final.component.html',
  styleUrls: []
})


export class RegisterFinalComponent implements OnInit {
  registerForm: FormGroup;

  constructor(private fb: FormBuilder) {
  }

  ngOnInit() {
    this.registerForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      pwGroup: this.fb.group({
        password: ['', [Validators.required, Validators.minLength(6)]],
        confirmPassword: ['', [Validators.required, Validators.minLength(6)]]
      }, {validator: comparePassword}),
      country: ['', Validators.required],
      age: ['', [Validators.required, Validators.min(18)]],
      gender: ['', Validators.required],
      phone: ['', [Validators.required, Validators.pattern(/^\+84\d{9,10}$/)]]
    });

    // update form state
    this.registerForm.patchValue({
      email: 'abc@gmail.com'
    });
  }

  onSubmit() {
    console.log(this.registerForm);
  }
}
