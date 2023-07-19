import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Contestazioni_eliosDTO } from 'src/api/model/contesatzioni_eliosDTO';
import { contestazioniEliosservice } from 'src/api/service/contestazioni_elios.service';

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
  valoreStato: string = '';
  //* ----------------------------------------------------------------

  datasource: Contestazioni_eliosDTO[] = []; // Dichiarazione di un array di tipo Contestazioni_eliosDTO per il datasource

  constructor(
    private contestazioniService: contestazioniEliosservice,
    private http: HttpClient
  ) {}

  ngOnInit(): void {
    this.contestazioniService.getContesatzioni_elios().subscribe((res) => {
      this.datasource = res;
      console.log(JSON.stringify(res));
    }); // Assegnamento del risultato dell'observable al datasource dell'array
  }

  //! Ce ne deve essere una per ogni campo del form !
  //! Funzioni che permettono di immagazzinare il valore dei textForm in delle variabili
  //? Metodo per prendere l'input di ID
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

  //? X i datepicker
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
    console.log(this.valoreDateOut); // Ciao commento
    return this.valoreDateOut;
  }

  //? Per i select
  sceltaStato(event: Event): string {
    this.valoreStato = (<HTMLInputElement>event.target).value;
    console.log('Stato: ' + this.valoreStato); // Per verificare che effettivamente prende l'input
    return this.valoreStato;
  }

  // Bottoni contestazioni
  bottoneModifica() {
    console.log('bottone modifica funzionante!');
  }
  bottoneVisualizza() {
    console.log('bottone visualizza funzionante!');
  }
  bottoneElimina(id: number) {
    const url = "http://localhost:8080/elios/delete/" + id;

    fetch(url, {
      method: 'DELETE',
    })
      .then((response) => {
        if (response.ok) {
          console.log('Elemento eliminato con successo!');
        } else {
          console.log("Si è verificato un errore durante l'eliminazione.");
        }
      })
      .catch((error) => {
        console.error('Si è verificato un errore nella richiesta:', error);
      });
  }

  bottoneScarica() {
    console.log('bottone scarica funzionante!');
  }
}
