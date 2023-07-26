import { Component } from '@angular/core';
// Import delle librerie necessarie
import { HttpClient } from '@angular/common/http'; // Per eseguire richieste HTTP 
import { Observable } from 'rxjs'; // Per supportare la programmazione reattiva con Observable
import { Contestazioni_eliosDTO } from 'src/api/model/contesatzioni_eliosDTO'; // Import del modello per le contestazioni
import { eliosFiltroDTO } from 'src/api/model/eliosFiltroDTO'; // Import del modello per il filtro
import { contestazioniEliosservice } from 'src/api/service/contestazioni_elios.service'; // Import del servizio per le contestazioni

@Component({
  selector: 'app-add-cont',
  templateUrl: './add-cont.component.html',
  styleUrls: ['./add-cont.component.scss']
})
export class AddContComponent {
  //*----------------------------------------------------------------
  //* Variabili:




  //*----------------------------------------------------------------
  //* Funciton:

  /*1) Funtion: confirmCreation()--> la funzione deve passare i valori al DB da POST
  //!  Ma come si fa?
  */
  confirmCreation(): void {
    console.log('confirmCreation va!!');
  }
}
