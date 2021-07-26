import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  second = '';
  message = '';
  number = '';
  title = 'exercise';
  display(e: string[]) {
    this.second = e[0];
    this.message = e[1];
  }
}
