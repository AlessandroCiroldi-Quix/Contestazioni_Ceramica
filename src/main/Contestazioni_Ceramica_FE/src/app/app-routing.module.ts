import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormComponent } from './form/form.component';
import { AddContComponent } from './components/add-cont/add-cont.component';
import { ModContComponent } from './components/mod-cont/mod-cont.component';

const routes: Routes = [
  {path: '', component: FormComponent},
  {path: 'add', component: AddContComponent},
  {path: 'edit', component: ModContComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
 