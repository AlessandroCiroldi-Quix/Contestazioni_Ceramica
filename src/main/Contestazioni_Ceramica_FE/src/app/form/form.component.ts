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
export class FormComponent implements OnInit {
  valoreID_cont: string = ''; // Dichiarazione di una variabile di tipo stringa per l'ID della contestazione

  datasource: Contestazioni_eliosDTO[] = []; // Dichiarazione di un array di tipo Contestazioni_eliosDTO per il datasource

  constructor(private contestazioniService: contestazioniEliosservice) {}

  ngOnInit(): void {
    this.contestazioniService
      .getContesatzioni_elios()
      .subscribe((res) => {this.datasource = res
        console.log(JSON.stringify(res))}); // Assegnamento del risultato dell'observable al datasource dell'array

  }

  // Funzione che prende l'input da tastiera e lo assegna alla variabile
  //! Ce ne deve essere una per ogni form !
  onInputID_cont(event: Event): string {
    console.log((<HTMLInputElement>event.target).value);
    this.valoreID_cont = (<HTMLInputElement>event.target).value;
    return this.valoreID_cont;
  }
}

