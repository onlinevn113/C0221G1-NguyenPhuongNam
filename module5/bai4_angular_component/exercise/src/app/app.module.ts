import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CalculatorComponent } from './bai3_angular_overviews/calculator/calculator.component';
import {FormsModule} from '@angular/forms';
import { ColorComponent } from './bai3_angular_overviews/color/color.component';
import { ArticleComponent } from './bai4_angular_component&template/article/article.component';
import { LikeComponent } from './bai4_angular_component&template/like/like.component';
import { NavbarComponent } from './bai4_angular_component&template/navbar/navbar.component';
import { FooterComponent } from './bai4_angular_component&template/footer/footer.component';
import { RatingBarComponentComponent } from './bai5_components_interaction/rating-bar-component/rating-bar-component.component';
@NgModule({
  declarations: [
    AppComponent,
    CalculatorComponent,
    ColorComponent,
    ArticleComponent,
    LikeComponent,
    NavbarComponent,
    FooterComponent,
    RatingBarComponentComponent,
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,

    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
