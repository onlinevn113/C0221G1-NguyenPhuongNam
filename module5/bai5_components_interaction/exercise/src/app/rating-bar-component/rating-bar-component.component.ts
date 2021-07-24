import { Component, OnInit } from '@angular/core';
import {LoadCssService} from '../bootstrap/load-css.service';

@Component({
  selector: 'app-rating-bar-component',
  templateUrl: './rating-bar-component.component.html',
  styleUrls: ['./rating-bar-component.component.css']
})
export class RatingBarComponentComponent implements OnInit {
  arr = [1, 2 , 3, 4, 5, 6, 7, 8, 9, 10];
  choice = 1;
  constructor() {
  }

  ngOnInit(): void {
  }
  public mounseOver(num: number){
    this.choice = num;
  }
}
