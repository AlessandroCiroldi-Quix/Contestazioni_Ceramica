// Import delle librerie necessarie
import { HttpClient } from '@angular/common/http'; // Per eseguire richieste HTTP
import { Component, OnInit } from '@angular/core'; // Component decorator e OnInit interface
import { Observable } from 'rxjs'; // Per supportare la programmazione reattiva con Observable
import { Contestazioni_eliosDTO } from 'src/api/model/contesatzioni_eliosDTO'; // Import del modello per le contestazioni
import { eliosFiltroDTO } from 'src/api/model/eliosFiltroDTO'; // Import del modello per il filtro
import { contestazioniEliosservice } from 'src/api/service/contestazioni_elios.service'; // Import del servizio per le contestazioni

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss'],
})
export class FormComponent implements OnInit {
  //* Variabili

  // Dichiarazione delle variabili per immagazzinare i valori del form
  valoreID_cont: string = ''; // ID della contestazione
  valoreCod_art: string = ''; // Codice articolo
  valoreCliente: string = ''; // Nome del cliente
  valoreDateIni: Date; // Data iniziale selezionata tramite datepicker
  valoreDateOut: Date; // Data finale selezionata tramite datepicker
  valoreStato: string = ''; // Stato selezionato tramite select

  // Dichiarazione di un oggetto eliosFiltroDTO con valori di default per i filtri
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

  // Dichiarazione di un array di tipo Contestazioni_eliosDTO per il datasource
  datasource: Contestazioni_eliosDTO[] = [];

  //* ----------------------------------------------------------------

  // Costruttore del componente con iniezione dei servizi
  constructor(
    private contestazioniService: contestazioniEliosservice,
    private http: HttpClient
  ) {}

  // Metodo chiamato all'inizializzazione del componente
  ngOnInit(): void {
    // Ottenimento delle contestazioni dal servizio all'avvio del componente
    this.contestazioniService.getContesatzioni_elios().subscribe((res) => {
      this.datasource = res;
      //console.log(JSON.stringify(res));
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

  // Metodo per prendere l'input di Codice Articolo
  onInputCod_art(event: Event): string {
    this.valoreCod_art = (<HTMLInputElement>event.target).value;
    console.log('Cod_art: ' + this.valoreCod_art); //Queste console.log sono di prova
    return this.valoreCod_art;
  }

  // Metodo per prendere l'input del Cliente
  onInputCliente(event: Event): string {
    this.valoreCliente = (<HTMLInputElement>event.target).value;
    console.log('Cliente: ' + this.valoreCliente); //Queste console.log sono di prova
    return this.valoreCliente;
  }

  // Metodo per salvare il valore della data iniziale selezionata tramite il datepicker
  salvareValoreDateIni(event: Event): Date {
    const target = event.target as HTMLInputElement;
    this.valoreDateIni = new Date(target.value);
    console.log(this.valoreDateIni);
    return this.valoreDateIni;
  }

  // Metodo per salvare il valore della data finale selezionata tramite il datepicker
  salvareValoreDateOut(event: Event): Date {
    const pick = event.target as HTMLInputElement;
    this.valoreDateOut = new Date(pick.value);
    console.log(this.valoreDateOut); // Ciao commento
    return this.valoreDateOut;
  }

  // Metodo per salvare lo stato selezionato tramite il select
  sceltaStato(event: Event): string {
    this.valoreStato = (<HTMLInputElement>event.target).value;
    console.log('Stato: ' + this.valoreStato); // Per verificare che effettivamente prende l'input
    return this.valoreStato;
  }

  //* ----------------------------------------------------------------
  // Bottoni contestazioni

  // Metodo chiamato quando il bottone "Modifica" viene cliccato
  bottoneModifica() {
    console.log('bottone modifica funzionante!');
  }

  // Metodo chiamato quando il bottone "Visualizza" viene cliccato
  bottoneVisualizza() {
    console.log('bottone visualizza funzionante!');
  }

  // Metodo chiamato quando il bottone "Elimina" viene cliccato
  bottoneElimina(id: number) {
    const url = 'http://localhost:8080/elios/delete/' + id;

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
    location.reload();
  }

  // Metodo chiamato quando il bottone "Scarica" viene cliccato
  bottoneScarica() {
    console.log('bottone scarica funzionante!');
  }

  // Metodo per ottenere le contestazioni tramite i filtri selezionati
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
