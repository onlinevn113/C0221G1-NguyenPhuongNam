import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import {FormsModule} from '@angular/forms';

import { TestComponent } from './test/test.component';
import { ArticleComponent } from './bai4_angular_component&template/article/article.component';
import { LikeComponent } from './bai4_angular_component&template/like/like.component';


@NgModule({
  declarations: [
    AppComponent,

    TestComponent,
    ArticleComponent,
    LikeComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
