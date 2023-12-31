// Import delle librerie necessarie
import { HttpClient } from '@angular/common/http'; // Per eseguire richieste HTTP
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core'; // Component decorator e OnInit interface
import { Contestazioni_eliosDTO } from 'src/api/model/contesatzioni_eliosDTO'; // Import del modello per le contestazioni
import { eliosFiltroDTO } from 'src/api/model/eliosFiltroDTO'; // Import del modello per il filtro
import { contestazioniEliosservice } from 'src/api/service/contestazioni_elios.service'; // Import del servizio per le contestazioni
import { formatISO } from 'date-fns';

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
  valoreDateIni: string; // Data iniziale selezionata tramite datepicker
  valoreDateOut: string; // Data finale selezionata tramite datepicker
  valoreStato: string = ''; // Stato selezionato tramite select
  valoreReparto: string = ''; 
  valoreFormato: string = '';
  valoreUtenteCreatore: string = '';

  // Variabili per il pageCounter
  currentPage: number = 1; // Counter per le pagine della tabella
  itemsPerPage: number = 15; // Numero di righe max che puoi visualizzare in una pagina della tabella
  rowCount: number;

  // Dichiarazione di un oggetto eliosFiltroDTO con valori di default per i filtri
  eliosFiltroDTO: eliosFiltroDTO = {
    id: 0,
    data_creazione: null,
    data_ultima_mod: null,
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

  //! ----------------------------------------------------------------
  //* Funzioni del Form

  // Metodo chiamato all'inizializzazione del componente
  ngOnInit(): void {
    // Ottenimento delle contestazioni dal servizio all'avvio del componente
    this.contestazioniService.getContesatzioni_elios().subscribe((res) => {
      this.datasource = res;
      console.log("Conteggio contestazioni"+res.length);
      this.rowCount = res.length;
    }); // Assegnamento del risultato dell'observable al datasource dell'array
  }

  //* Funzioni che permettono di immagazzinare il valore dei textForm in delle variabili

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

  convertiFormatoData(data: Date): string {
    // Utilizza la funzione formatISO per ottenere la data in formato ISO 8601 (timestamp)
    return formatISO(data);
  }

  // Modifica la funzione salvareValoreDateIni
  salvareValoreDateIni(event: Event): string {
    this.valoreDateIni = (<HTMLInputElement>event.target).value;
    console.log('Data In: ' + this.valoreDateIni + typeof this.valoreDateIni); //Queste console.log sono di prova
    return this.valoreDateIni;
  }

  // Metodo per salvare il valore della data finale selezionata tramite il datepicker
  salvareValoreDateOut(event: Event): string {
    this.valoreDateOut = (<HTMLInputElement>event.target).value;
    console.log('Cliente: ' + this.valoreDateOut); //Queste console.log sono di prova
    return this.valoreDateOut;
  }
  // Metodo per salvare lo stato selezionato tramite il select
  sceltaStato(event: Event): string {
    this.valoreStato = (<HTMLInputElement>event.target).value;
    console.log('Stato: ' + this.valoreStato); // Per verificare che effettivamente prende l'input
    return this.valoreStato;
  }

  sceltaReparto(event: Event): string {
    this.valoreReparto = (<HTMLInputElement>event.target).value;
    console.log('Stato: ' + this.valoreReparto); // Per verificare che effettivamente prende l'input
    return this.valoreReparto;
  }
  
  sceltaUtenteCreatore(event: Event): string {
    this.valoreUtenteCreatore = (<HTMLInputElement>event.target).value;
    console.log('Utente creatore: ' + this.valoreUtenteCreatore); // Per verificare che effettivamente prende l'input
    return this.valoreUtenteCreatore;
  }
  
  sceltaFormato(event: Event): string {
    this.valoreFormato = (<HTMLInputElement>event.target).value;
    console.log('Utente creatore: ' + this.valoreFormato); // Per verificare che effettivamente prende l'input
    return this.valoreFormato;
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
    location.reload();
    location.reload();
  }
  // Metodo chiamato quando il bottone "Scarica" viene cliccato
  bottoneScarica() {
    console.log('bottone scarica funzionante!');
  }

  // Metodo per ottenere le contestazioni tramite i filtri selezionati
  getContestationByFiltro(
    id: any,
    data_creazione: string,
    data_ultima_mod: string,
    cod_articolo: any,
    rs_cliente: any,
    stato: string,
    reparto: string,
    utente_creazione: any,
    ) {
    // formato: any utente_creazione: any, reparto: any,
    this.eliosFiltroDTO.id = id;
    this.eliosFiltroDTO.data_creazione = data_creazione;
    this.eliosFiltroDTO.data_ultima_mod = data_ultima_mod;
    this.eliosFiltroDTO.cod_articolo = cod_articolo;
    this.eliosFiltroDTO.rs_cliente = rs_cliente;
    this.eliosFiltroDTO.stato = stato;
    this.eliosFiltroDTO.reparto = reparto;
    this.eliosFiltroDTO.utente_creazione = utente_creazione;
    //this.eliosFiltroDTO.formato = formato;

    this.contestazioniService
      .eliosFiltro(this.eliosFiltroDTO)
      .subscribe((res) => {
        console.log(JSON.stringify(res));
        this.datasource = res;
      });
  }

  //! Funzioni per la tabella
  getCurrentPageData(): any[] {
    const startIndex = (this.currentPage - 1) * this.itemsPerPage;
    const endIndex = startIndex + this.itemsPerPage;
    return this.datasource.slice(startIndex, endIndex);
  }

  goToPage(pageNumber: number): void {
    if (pageNumber >= 1 && pageNumber <= this.getTotalPages()) {
      this.currentPage = pageNumber;
    }
  }

  isLastPage(): boolean {
    return this.currentPage === this.getTotalPages();
  }

  getTotalPages(): number {
    return Math.ceil(this.datasource.length / this.itemsPerPage);
  }

  //* Funzione per il pulsante ricarica tabella
  /*
  Quando si preme il pulsante dovrebbe rigenerare la query select all al database
  */
  reloadTable() {
    // Rifà la chaiamta al Database
    this.contestazioniService.getContesatzioni_elios().subscribe((res) => {
      console.log(JSON.stringify(res) + 'funziona');
      this.datasource = res;
    });
  }

  @ViewChild('myTable', { static: false }) myTable: ElementRef;

  ngAfterViewInit() {
    this.countAndPrintRows();
  }

  countAndPrintRows(): number {
    const tableElement: HTMLTableElement = this.myTable.nativeElement;
    const rowCount = tableElement.rows.length;

    console.log('Numero di righe nella tabella:', rowCount + 1);
    console.log(this.datasource);
    return rowCount;
  }

  reloadPage() {
    location.reload();
  }
}
