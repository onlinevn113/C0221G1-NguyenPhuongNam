import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule} from '@angular/forms';
import { ArticleComponent } from './bai4_angular_component&template/article/article.component';
import { LikeComponent } from './bai4_angular_component&template/like/like.component';
import { NavbarComponent } from './bai4_angular_component&template/navbar/navbar.component';
import { FooterComponent } from './bai4_angular_component&template/footer/footer.component';
@NgModule({
  declarations: [
    AppComponent,
    ArticleComponent,
    LikeComponent,
    NavbarComponent,
    FooterComponent,
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,

    ],
    providers: [],
    exports: [
        FooterComponent
    ],
    bootstrap: [AppComponent]
})
export class AppModule { }
