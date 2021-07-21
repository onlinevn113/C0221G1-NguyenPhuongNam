import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  a = 0;
  b = 0;
  tinhToan = '+';
  c = 0;

  calculator(phepTinh) {
    this.tinhToan = phepTinh.target.value;
  }
  result(){
    switch (this.tinhToan) {
      case '+':
        this.c = this.a + this.b;
        break;
      case '-':
        this.c = this.a - this.b;
        break;
      case '*':
        this.c = this.a * this.b;
        break;
      case '/':
        this.c = this.a / this.b;
        break;
    }
  }

  constructor() {
  }

  ngOnInit(): void {
  }

}
