import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Contestazioni_eliosDTO } from 'src/api/model/contesatzioni_eliosDTO';
import { eliosFiltroDTO } from 'src/api/model/eliosFiltroDTO';
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

  eliosFiltroDTO: eliosFiltroDTO = {
    id: 0,
    data_creazione: '',
    data_ultima_mod: '',
    cod_articolo: '',
    rs_cliente: '',
    stato: '',
    reparto: '',
    formato: '',
    utente_creazione: '',
  };
  datasource: Contestazioni_eliosDTO[] = []; // Dichiarazione di un array di tipo Contestazioni_eliosDTO per il datasource
  private baseUrl = 'http://localhost:8080/elios/delete/';

  //* ----------------------------------------------------------------

  constructor(
    private contestazioniService: contestazioniEliosservice,
    private http: HttpClient
  ) {}

  ngOnInit(): void {
    this.contestazioniService.getContesatzioni_elios().subscribe((res) => {
      this.datasource = res;
      //console.log(JSON.stringify(res));
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

  async bottoneElimina(id: number) {
    const url = `${this.baseUrl}${id}`;
    try {
      await this.http.delete(url).toPromise();
      console.log(`Elemento con id ${id} eliminato con successo.`);
      // Puoi anche aggiornare la tua UI o fare altre operazioni qui in caso di successo.
    } catch (error) {
      console.error(
        `Errore durante l'eliminazione dell'elemento con id ${id}:`,
        error
      );
      // Puoi gestire l'errore in modo appropriato, aggiornare la tua UI, o fornire un messaggio di errore all'utente.
    }
  }

  bottoneScarica() {
    console.log('bottone scarica funzionante!');
  }

  getContestationByFiltro(id: any) {
    console.log(id);
    this.eliosFiltroDTO.id = id;
    this.contestazioniService
      .eliosFiltro(this.eliosFiltroDTO)
      .subscribe((res) => {
        console.log(JSON.stringify(res));
        this.datasource = res;
      });
  }
}
