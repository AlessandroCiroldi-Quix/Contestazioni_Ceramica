import { Component, OnInit } from '@angular/core';
import { Contestazioni_eliosDTO } from 'src/api/model/contesatzioni_eliosDTO';
import { contestazioniEliosservice } from 'src/api/service/contestazioni_elios.service';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss'],
})
export class FormComponent implements OnInit {
  //* Variabili
  valoreID_cont: string = ''; // Dichiarazione di una variabile di tipo stringa per l'ID della contestazione
  valoreCod_art: string = '';
  valoreCliente: string = '';
  valoreDateIni: Date; // Dichiarazione della variabile per immagazzinare il valore del datepicker
  valoreDateOut: Date;
  //* ----------------------------------------------------------------

  datasource: Contestazioni_eliosDTO[] = []; // Dichiarazione di un array di tipo Contestazioni_eliosDTO per il datasource

  constructor(private contestazioniService: contestazioniEliosservice) {}

  ngOnInit(): void {
    this.contestazioniService.getContesatzioni_elios().subscribe((res) => {
      this.datasource = res;
      console.log(JSON.stringify(res));
    }); // Assegnamento del risultato dell'observable al datasource dell'array
  }

  //! Ce ne deve essere una per ogni campo del form !
  //! Funzioni che permettono di immagazzinare il valore dei textForm in delle variabili
  // Metodo per prendere l'input di ID
  onInputID_cont(event: Event): string {
    this.valoreID_cont = (<HTMLInputElement>event.target).value;
    console.log('ID: ' + this.valoreID_cont); // Per verificare che effettivamente prende l'input
    return this.valoreID_cont;
  }

  onInputCod_art(event: Event): string {
    this.valoreCod_art = (<HTMLInputElement>event.target).value;
    console.log('Cod_art: ' + this.valoreCod_art); //Queste console.log sono di prova
    return this.valoreCod_art;
  }

  onInputCliente(event: Event): string {
    this.valoreCliente = (<HTMLInputElement>event.target).value;
    console.log('Cliente: ' + this.valoreCliente); //Queste console.log sono di prova
    return this.valoreCliente;
  }

  // per salvare il valore della data
  salvareValoreDateIni(event: Event): Date {
    const target = event.target as HTMLInputElement;
    this.valoreDateIni = new Date(target.value);
    console.log(this.valoreDateIni);
    return this.valoreDateIni;
  } 

  salvareValoreDateOut(event: Event): Date {
    const pick = event.target as HTMLInputElement;
    this.valoreDateOut = new Date(pick.value);
      console.log(this.valoreDateOut);  // Ciao commento
    return this.valoreDateOut;
  }
}
 