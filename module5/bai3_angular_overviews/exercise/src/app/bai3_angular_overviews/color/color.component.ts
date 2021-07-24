import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-color',
  templateUrl: './color.component.html',
  styleUrls: ['./color.component.css']
})
export class ColorComponent implements OnInit {
  color = 'red';
  red: number;
  green: number;
  blue: number;

  constructor() {
  }

  ngOnInit(): void {
  }

  changColor(color) {
    this.color = color.target.value;
  }


}
