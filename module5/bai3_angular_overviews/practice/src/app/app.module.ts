import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FontSizeEditorComponent } from './bai3_angular_overviews/font-size-editor/font-size-editor.component';
import { PetComponent } from './bai3_angular_overviews/pet/pet.component';
import {FormsModule} from '@angular/forms';
import { ProductComponent } from './bai3_angular_overviews/product/product.component';
import { TestComponent } from './test/test.component';
import { ArticleComponent } from './bai4_angular_component&template/article/article.component';
import { LikeComponent } from './bai4_angular_component&template/like/like.component';
import { NameCardComponent } from './bai5_components_interaction/name-card/name-card.component';
import { ProgressBarComponent } from './bai5_components_interaction/progress-bar/progress-bar.component';

@NgModule({
  declarations: [
    AppComponent,
    FontSizeEditorComponent,
    PetComponent,
    ProductComponent,
    TestComponent,
    ArticleComponent,
    LikeComponent,
    NameCardComponent,
    ProgressBarComponent,
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
