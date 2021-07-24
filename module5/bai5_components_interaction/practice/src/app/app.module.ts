import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { NameCardComponent } from './bai5_components_interaction/name-card/name-card.component';
import { ProgressBarComponent } from './bai5_components_interaction/progress-bar/progress-bar.component';

@NgModule({
  declarations: [
    AppComponent,

    NameCardComponent,
    ProgressBarComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
