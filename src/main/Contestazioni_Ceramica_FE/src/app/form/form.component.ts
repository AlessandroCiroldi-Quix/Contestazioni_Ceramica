import { Component, Inject, OnInit } from '@angular/core';
import { Contestazioni_eliosDTO } from 'src/api/model/contesatzioni_eliosDTO';
import { contestazioniEliosservice } from 'src/api/service/contestazioni_elios.service';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss'],
  //standalone: true,
})
export class FormComponent implements OnInit {
  valoreID_cont: string = ''; // Dichiarazione di una variabile di tipo stringa per l'ID della contestazione

  datasource: Contestazioni_eliosDTO[] = []; // Dichiarazione di un array di tipo Contestazioni_eliosDTO per il datasource

  constructor(private contestazioniService: contestazioniEliosservice, private http: HttpClient) {}

  ngOnInit(): void {
    this.contestazioniService
      .getContesatzioni_elios()
      .subscribe((res) => {this.datasource = res
        console.log(JSON.stringify(res))}); // Assegnamento del risultato dell'observable al datasource dell'array

  }

  // Funzione che prende l'input da tastiera e lo assegna alla variabile
  //! Ce ne deve essere una per ogni campo del form !
  onInputID_cont(event: Event): string {
    this.valoreID_cont = (<HTMLInputElement>event.target).value;
    console.log(this.valoreID_cont);  // Per verificare che effettivamente prende l'input
    return this.valoreID_cont;
  }

  onClick() {
    // Ottieni i valori dei campi del form
    const id = this.valoreID_cont;


    // Costruisci l'oggetto di ricerca
    const ricerca = {
      campo1: id,
    };

    // Effettua la richiesta HTTP al backend
    this.http.post('/url-della-tua-api-di-ricerca', ricerca).subscribe(
      (risposta) => {
        // Gestisci la risposta del backend qui
        console.log("Paolo: ", risposta);
      },
      (errore) => {
        // Gestisci eventuali errori qui
        console.error(errore);
      }
    );
  }

}

