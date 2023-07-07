import { Component, OnInit } from '@angular/core';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { Contestazioni_eliosDTO } from 'src/api/model/contesatzioni_eliosDTO';
import { contestazioniEliosservice } from 'src/api/service/contestazioni_elios.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html', 
  styleUrls: ['./form.component.scss'],
})
export class FormComponent implements OnInit{
  valoreID_cont: string = '';
  datasource: Contestazioni_eliosDTO[] = [];
  constructor(private contestazioniService: contestazioniEliosservice) {}

  ngOnInit(): void {
    this.contestazioniService.getContesatzioni_elios().subscribe( res => 
      this.datasource = res
    );
  }

  onInputID_cont(event: Event): string {
    console.log((<HTMLInputElement>event.target).value);
    this.valoreID_cont = (<HTMLInputElement>event.target).value;
    return this.valoreID_cont;
  }

}


