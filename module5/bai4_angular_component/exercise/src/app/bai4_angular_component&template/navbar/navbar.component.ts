import { Component, OnInit } from '@angular/core';
import {LoadCssService} from '../../bootstrap/load-css.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  constructor(private loadService: LoadCssService) {
    loadService.loadCss('https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css');
  }
  ngOnInit(): void {
  }
}
