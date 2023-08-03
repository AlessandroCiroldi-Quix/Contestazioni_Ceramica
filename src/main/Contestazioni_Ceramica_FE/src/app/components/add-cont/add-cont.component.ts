import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Location } from '@angular/common';

// Import delle librerie necessarie

@Component({
  selector: 'app-add-cont',
  templateUrl: './add-cont.component.html',
  styleUrls: ['./add-cont.component.scss'],
})
export class AddContComponent {
  constructor(private http: HttpClient, private location: Location) {}

  //*----------------------------------------------------------------
  //* Variabili:
  valoreCod_art: string = '';
  valoreTono: string = '';
  valoreQta_cont: string = '';
  valoreUm_cont: string = '';
  valorePosato: string = '';
  valoreCliente: string = '';
  valoreNum_fattura: string = '';
  valoreNum_bolla: string = '';
  valoreNum_buono: string = '';
  valoreNum_ordineReparto: string = '';
  valoreData_fattura: Date;
  valoreDifettosita: string = '';
  valoreReparto: string = '';
  valoreDescrizione: string = '';
  valoreStato: string = '';

  //*----------------------------------------------------------------
  //* Funciton:
  /*1) Funtion: confirmCreation()--> la funzione deve passare i valori al DB da POST
  //!  Ma come si fa?
  */
  //! Per il momento la funzione FUNZIONA!! INCREDIBILE, ora i passaggi sono capire come si fa a passarli IL JSON, ovvero i valori dei filtri
  confirmCreation(): void {
    const url = 'http://localhost:8080/elios/add';

    // Il JSON da inviare come dati della richiesta POST
    const jsonData = {
      // ID: Autoincrement,
      cod_cliente: 'Null', //varchar(50)
      rs_cliente: this.valoreCliente, //varchar(255)
      cod_articolo: this.valoreCod_art, //varchar(50)
      tono: this.valoreTono, //varchar(50)
      num_fattura: this.valoreNum_fattura, //varchar(255)
      data_fattura: this.valoreData_fattura, // Date
      descrizione: 'Null', // text Descrizione prodotto
      qta_contestata: this.valoreQta_cont, //int(11)
      unita_misura: this.valoreUm_cont, //varchar(10)
      posato: this.valorePosato, //tinyint(1)
      stato: this.valoreStato, // varchar(20)
      utente_creazione: 'Null', //varchar(45)
      data_creazione: '2023-06-22T10:30:00.000+00:00', //Timestamp
      utente_ultima_mod: null, //varchar(45)
      data_ultima_mod: '2020-06-02T01:02:03.000+00:00', //Timestamp
      desc_prodotto: this.valoreDescrizione, //text
      uid_files: null, //varchar(36)
      tipology: null, //varchar(255)
      motivazione: 'Null', //text
      company: 'ELI', // varchar(50)  //Enum
      num_buono: this.valoreNum_buono, //varchar(45)
      num_bolla: this.valoreNum_bolla, //varchar(45)
      num_ord_reparto: this.valoreNum_ordineReparto, //varchar(45)
      difettosita: this.valoreDifettosita, //varchar(45)
      deleted: 0, //tinyint(1)
    };

    // Imposta gli header se necessario (ad esempio, se il server richiede header specifici)
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
    });
    // Effettua la richiesta POST utilizzando il modulo HttpClient
    this.http.post(url, jsonData, { headers }).subscribe(
      // Callback per gestire la risposta del server in caso di successo
      (response) => {
        console.log('Richiesta POST riuscita!' + 'POST COMPLETE', response);
      },
      // Callback per gestire eventuali errori durante la richiesta
      (error) => {
        console.error('Errore durante la richiesta POST: ERROR!!', error);
      }
    );
  }

  AlertMessage(message: string): void {
    alert(message);
  }

  goBack(): void {
    this.location.back();
  }

  //*----------------------------------------------------------------
  // Funzioni GET per ottenere il valore dal form e inserirli dentro una variabile:
  onInputCliente(event: Event): string {
    this.valoreCliente = (<HTMLInputElement>event.target).value;
    console.log('TONO: ' + this.valoreCliente); // Per verificare che effettivamente prende l'input
    return this.valoreCliente;
  }

  onInputCod_art(event: Event): string {
    this.valoreCod_art = (<HTMLInputElement>event.target).value;
    //Funzione di verifica
    this.verificaCod_Articolo(this.valoreCod_art);
    console.log('Cod_art: ' + this.valoreCod_art);
    return this.valoreCod_art;
  }

  onInputTono(event: Event): string {
    this.valoreTono = (<HTMLInputElement>event.target).value;
    //this.verificaFormato(this.valoreTono);
    console.log('Cod_art: ' + this.valoreTono);
    return this.valoreTono;
  }

  onInputNum_fattura(event: Event): string {
    this.valoreNum_fattura = (<HTMLInputElement>event.target).value;
    console.log('TONO: ' + this.valoreNum_fattura); // Per verificare che effettivamente prende l'input
    return this.valoreNum_fattura;
  }

  onInputData(event: Event): Date {
    let inputElement = <HTMLInputElement>event.target;
    let selectedDateStr = inputElement.value;

    // Converti la stringa in un oggetto Date
    const selectedDate = new Date(selectedDateStr);

    this.valoreData_fattura = selectedDate; // Per verificare che effettivamente prende l'input
    return this.valoreData_fattura;
  }

  onInputQta_cont(event: Event): number {
    this.valoreQta_cont = (<HTMLInputElement>event.target).value;
    if (this.valoreQta_cont.length > 11) {
      console.log('Errore: Valore di Qta_con troppo lungo!');
    } else {
      console.log('TONO: ' + this.valoreQta_cont); // Per verificare che effettivamente prende l'input
    }
    return parseInt(this.valoreQta_cont);
  }

  onInputUm_cont(event: Event): string {
    this.valoreUm_cont = (<HTMLInputElement>event.target).value;
    console.log('TONO: ' + this.valoreUm_cont); // Per verificare che effettivamente prende l'input
    return this.valoreUm_cont;
  }

  onInputPosato(event: Event): string {
    this.valorePosato = (<HTMLInputElement>event.target).value;
    console.log('TONO: ' + this.valorePosato); // Per verificare che effettivamente prende l'input
    return this.valorePosato;
  }

  onInputStato(event: Event): string {
    this.valoreStato = (<HTMLInputElement>event.target).value;
    console.log('TONO: ' + this.valoreStato); // Per verificare che effettivamente prende l'input
    return this.valoreStato;
  }

  //TEXTAREA:
  onInputDescrizione(event: Event): string {
    this.valoreDescrizione = (<HTMLInputElement>event.target).value;
    console.log('DESCRIZIONE: ' + this.valoreDescrizione); // Per verificare che effettivamente prende l'input
    return this.valoreDescrizione;
  }

  onInputNum_buono(event: Event): string {
    this.valoreNum_buono = (<HTMLInputElement>event.target).value;
    console.log('TONO: ' + this.valoreNum_buono); // Per verificare che effettivamente prende l'input
    return this.valoreNum_buono;
  }

  onInputNum_bolla(event: Event): string {
    this.valoreNum_bolla = (<HTMLInputElement>event.target).value;
    console.log('TONO: ' + this.valoreNum_bolla); // Per verificare che effettivamente prende l'input
    return this.valoreNum_bolla;
  }

  onInputNum_ordineReparto(event: Event): string {
    this.valoreNum_ordineReparto = (<HTMLInputElement>event.target).value;
    console.log('TONO: ' + this.valoreNum_ordineReparto); // Per verificare che effettivamente prende l'input
    return this.valoreNum_ordineReparto;
  }

  onInputDifettosita(event: Event): string {
    this.valoreDifettosita = (<HTMLInputElement>event.target).value;
    console.log('TONO: ' + this.valoreDifettosita); // Per verificare che effettivamente prende l'input
    return this.valoreDifettosita;
  }

  //! QUESTO RIMANE FUORI
  onInputReparto(event: Event): string {
    this.valoreReparto = (<HTMLInputElement>event.target).value;
    console.log('TONO: ' + this.valoreReparto); // Per verificare che effettivamente prende l'input
    return this.valoreReparto;
  }

  // ----------------------------------------------------------------
  //* Funzioni di verifica dei campi
  verificaCod_Articolo(codArticolo: string): boolean {
    // Verifica che la lunghezza della stringa sia al massimo 50
    if (typeof codArticolo === 'string' && codArticolo.length <= 50) {
      return true;
    } else {
      alert('Il codice cliente è valido. Max 50!');
      location.reload();
      console.log(
        'Il codice cliente non è valido. Assicurati che sia una stringa di massimo 50 caratteri.'
      );
      return false;
    }
  }
}
