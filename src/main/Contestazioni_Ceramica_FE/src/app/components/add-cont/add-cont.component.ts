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
      cod_cliente: 'Null',
      rs_cliente: 'Cliente A', //!
      cod_articolo: 'ART001', //!
      tono: 'Tono A', //!
      num_fattura: null, //!
      data_fattura: null, //!
      descrizione: 'Null', // Descrizione prodotto
      qta_contestata: 10, //!
      unita_misura: 'Unità', //!
      posato: 1, //!
      stato: 'presa_in_carico', //!
      utente_creazione: 'Null',
      data_creazione: '2023-06-22T10:30:00.000+00:00',
      utente_ultima_mod: null,
      data_ultima_mod: '2020-06-02T01:02:03.000+00:00',
      desc_prodotto: 'Descrizione dettagliata prodotto', //! // Descrizione problema dettagliata
      uid_files: null,
      tipology: null,
      motivazione: 'Null',
      company: 'ELI', // Fisso per Elios
      num_buono: null, //!
      num_bolla: null, //!
      num_ord_reparto: null, //!
      difettosita: null, //!
      deleted: 0,
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
  onInputCod_art(event: Event): string {
    this.valoreCod_art = (<HTMLInputElement>event.target).value;
    //Funzione di verifica
    this.verificaCod_Articolo(this.valoreCod_art);
    return this.valoreCod_art;
  }

  onInputTono(event: Event): string {
    this.valoreTono = (<HTMLInputElement>event.target).value;
    //this.verificaFormato(this.valoreTono);
    return this.valoreTono;
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

  onInputCliente(event: Event): string {
    this.valoreCliente = (<HTMLInputElement>event.target).value;
    console.log('TONO: ' + this.valoreCliente); // Per verificare che effettivamente prende l'input
    return this.valoreCliente;
  }

  onInputNum_fattura(event: Event): string {
    this.valoreNum_fattura = (<HTMLInputElement>event.target).value;
    console.log('TONO: ' + this.valoreNum_fattura); // Per verificare che effettivamente prende l'input
    return this.valoreNum_fattura;
  }

  onInputNum_bolla(event: Event): string {
    this.valoreNum_bolla = (<HTMLInputElement>event.target).value;
    console.log('TONO: ' + this.valoreNum_bolla); // Per verificare che effettivamente prende l'input
    return this.valoreNum_bolla;
  }

  onInputNum_buono(event: Event): string {
    this.valoreNum_buono = (<HTMLInputElement>event.target).value;
    console.log('TONO: ' + this.valoreNum_buono); // Per verificare che effettivamente prende l'input
    return this.valoreNum_buono;
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

  onInputReparto(event: Event): string {
    this.valoreReparto = (<HTMLInputElement>event.target).value;
    console.log('TONO: ' + this.valoreReparto); // Per verificare che effettivamente prende l'input
    return this.valoreReparto;
  }

  //TEXTAREA:
  onInputDescrizione(event: Event): string {
    this.valoreDescrizione = (<HTMLInputElement>event.target).value;
    console.log('DESCRIZIONE: ' + this.valoreDescrizione); // Per verificare che effettivamente prende l'input
    return this.valoreDescrizione;
  }

  onInputStato(event: Event): string {
    this.valoreStato = (<HTMLInputElement>event.target).value;
    console.log('TONO: ' + this.valoreStato); // Per verificare che effettivamente prende l'input
    return this.valoreStato;
  }

  onInputData(event: Event): Date | null {
    const inputDate = (<HTMLInputElement>event.target).value;
    const dateValue = new Date(inputDate);

    // Verifica se la data è valida
    if (isNaN(dateValue.getTime())) {
      console.log('Data non valida'); // Puoi gestire l'errore in modo opportuno qui
      return null;
    }
    console.log('Data inserita: ' + dateValue.toISOString()); // Per verificare che effettivamente prende l'input
    return dateValue;
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
