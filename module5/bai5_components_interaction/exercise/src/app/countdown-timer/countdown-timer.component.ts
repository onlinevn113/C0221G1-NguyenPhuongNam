import {Component, EventEmitter, Input, OnDestroy, OnInit, Output} from '@angular/core';


@Component({
  selector: 'app-countdown-timer',
  templateUrl: './countdown-timer.component.html',
  styleUrls: ['./countdown-timer.component.css']
})
export class CountdownTimerComponent implements OnInit, OnDestroy {
  private interval: number;
  message = '';
  @Input() seconds: number;
  num;
  check = true;
  @Output() countChanged = new EventEmitter<string []>();

  constructor() {
  }

  ngOnInit() {
    this.reset();
  }

  ngOnDestroy() {
    this.clearTimer();
  }

  start() {
    this.message = 'Start';
    this.countDown();
    this.check = false;
    if (this.num <= 0) {
      this.num = this.seconds;
    }
  }

  clearTimer() {
    clearInterval(this.interval);
  }

  stop() {
    this.message = 'Stop';
    this.clearTimer();
    this.check = true;
  }

  reset() {
    this.stop();
    this.num = this.seconds;
    this.message = 'Reset';
    this.countChanged.emit([this.num + '', this.message]);
  }

  private countDown() {
    this.clearTimer();
    this.interval = setInterval(() => {
      this.countChanged.emit([this.num + '', this.message]);
      this.num--;
      if (this.num === 0) {
        this.message = 'Time out';
        this.clearTimer();
      }
    }, 1000);
  }
}
