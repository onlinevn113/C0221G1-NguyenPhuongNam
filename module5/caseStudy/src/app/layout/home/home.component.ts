import {Component, OnInit} from '@angular/core';
import {LoadCssService} from '../../bootstrap/load-css.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(private loadCss: LoadCssService) {
    loadCss.loadCss('https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css');
    // loadCss.loadCss('https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css');
    loadCss.loadScript('assets/script/nav-bar.js');
  }

  ngOnInit(): void {
  }

}
