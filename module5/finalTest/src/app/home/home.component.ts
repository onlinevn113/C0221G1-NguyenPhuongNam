import {Component, OnInit} from '@angular/core';
import {LoadCssService} from '../bootstrap/load-css.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(private load: LoadCssService) {
    load.loadCss('https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css');
    load.loadScript('assets/side-nav.js');
    load.loadScript('https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js');
    load.loadScript('https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js');
  }

  ngOnInit(): void {
  }

}
