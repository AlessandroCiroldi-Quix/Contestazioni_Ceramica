import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormComponent } from './form/form.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatTableModule} from '@angular/material/table';
import { contestazioniEliosservice } from 'src/api/service/contestazioni_elios.service';
import { HttpClientModule } from '@angular/common/http';
import { AddContComponent } from './components/add-cont/add-cont.component';
import { ModContComponent } from './components/mod-cont/mod-cont.component';




@NgModule({
  declarations: [AppComponent, FormComponent, AddContComponent, ModContComponent,],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    HttpClientModule,
    MatDatepickerModule,
    MatTableModule,
  ],
  providers: [contestazioniEliosservice],
  bootstrap: [AppComponent],  
})
export class AppModule {}
