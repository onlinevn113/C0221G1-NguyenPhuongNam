import { NgModule } from '@angular/core';

import {ListComponent} from './customer/list/list.component';
import {CreateComponent} from './customer/create/create.component';
import {EditComponent} from './customer/edit/edit.component';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {DanhSachComponent} from './benh_vien/danh-sach/danh-sach.component';
import {ChinhSuaComponent} from './benh_vien/chinh-sua/chinh-sua.component';



const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'customer',
    component: ListComponent
  },
  {
    path:'customer/create',
    component: CreateComponent
  },
  {
    path:'customer/edit/:id',
    component: EditComponent
  },
  {
    path:'benh-nhan',
    component: DanhSachComponent
  },
  {
    path:'benh-nhan/chinh-sua/:id',
    component: ChinhSuaComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
