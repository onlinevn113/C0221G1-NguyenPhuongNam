import {Component, OnInit} from '@angular/core';
import {LoadCssService} from '../bootstrap/load-css.service';

@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css']
})
export class FirstComponent implements OnInit {

  constructor(private load: LoadCssService) {
    load.loadScript('assets/side-nav.js');
    load.loadScript('https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js');
    load.loadScript('https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js');


  }

  ngOnInit(): void {
  }

}
