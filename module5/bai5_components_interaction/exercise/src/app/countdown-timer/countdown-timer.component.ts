import {Component, Input, OnDestroy, OnInit} from '@angular/core';


@Component({
  selector: 'app-countdown-timer',
  templateUrl: './countdown-timer.component.html',
  styleUrls: ['./countdown-timer.component.css']
})
export class CountdownTimerComponent implements OnInit, OnDestroy {
  private interval: number;
  message = '';
  @Input()
  seconds;
  check = true;

  constructor() {
  }

  ngOnInit() {
  }

  ngOnDestroy() {
  }

  start() {
    this.message = 'Start';
    this.countDown();
    this.check = false;
    // tslint:disable-next-line:triple-equals

  }

  clearTimer() {
    clearInterval(this.interval);
  }

  stop() {
    // tslint:disable-next-line:triple-equals
    this.message = 'Stop';
    this.clearTimer();
    this.check = true;
  }

  reset() {
    this.message = 'Reset';
    this.seconds = 0;
    this.stop();
  }

  private countDown() {

    this.interval = setInterval(() => {
      this.seconds = this.seconds + 1;
      // if (this.seconds <= -1) {
      //   this.stop();
      //   this.reset();
      // }
      // tslint:disable-next-line:triple-equals
      if (this.seconds == 100){
        this.seconds = 101;
      }
    }, 25);
  }
}
