import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

// Import delle librerie necessarie

@Component({
  selector: 'app-add-cont',
  templateUrl: './add-cont.component.html',
  styleUrls: ['./add-cont.component.scss'],
})
export class AddContComponent {
  constructor(private http: HttpClient) {}
  //*----------------------------------------------------------------
  //* Variabili:

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
      id: 1,
      cod_cliente: 'COD008',
      rs_cliente: 'Cliente A',
      cod_articolo: 'ART001',
      tono: 'Tono A',
      num_fattura: null,
      data_fattura: null,
      descrizione: 'Descrizione prodotto',
      qta_contestata: 10,
      unita_misura: 'Unità',
      posato: 1,
      stato: 'presa_in_carico',
      utente_creazione: 'Utente1',
      data_creazione: '2023-06-22T10:30:00.000+00:00',
      utente_ultima_mod: null,
      data_ultima_mod: '2020-06-02T01:02:03.000+00:00',
      desc_prodotto: 'Descrizione dettagliata prodotto',
      uid_files: null,
      tipology: null,
      motivazione: 'Motivazione del contesto',
      company: 'Nome azienda',
      num_buono: null,
      num_bolla: null,
      num_ord_reparto: null,
      difettosita: null,
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
        console.log('Richiesta POST riuscita!' + "POST COMPLETE", response);
      },
      // Callback per gestire eventuali errori durante la richiesta
      (error) => {
        console.error('Errore durante la richiesta POST: ERROR!!', error);
      }
    );
  } 
}
