import { HttpClient } from '@angular/common/http'; // Importa il modulo HttpClient per effettuare le richieste HTTP
import { Injectable } from '@angular/core'; // Importa il decoratore Injectable per creare un servizio injectable
import { Contestazioni_eliosDTO } from '../model/contesatzioni_eliosDTO'; // Importa il modello Contestazioni_eliosDTO
import { Observable } from 'rxjs'; // Importa Observable per gestire le risposte asincrone
import { eliosFiltroDTO } from '../model/eliosFiltroDTO';

@Injectable()
export class contestazioniEliosservice {
  static getContesatzioni_elios: any; // Variabile statica non utilizzata (potrebbe essere un errore)
  body: Observable<Contestazioni_eliosDTO[]>;

  // Metodo non implementato (può essere implementato successivamente)
  getContestazioni() {
    throw new Error('Method not implemented.');
  }

  protected basePath = 'http://localhost:8080/elios'; // Percorso di base per le richieste API
  constructor(private http: HttpClient) {} // Inietta HttpClient nel servizio

  getContesatzioni_elios(): Observable<Contestazioni_eliosDTO[]> {
    // Metodo per ottenere le contestazioni Elios come un array di Contestazioni_eliosDTO
    return this.http.get<Contestazioni_eliosDTO[]>(this.basePath + '/select');
    // Effettua una richiesta GET all'URL composto da basePath + '/select' e restituisce l'Observable di tipo Contestazioni_eliosDTO[]
  }

  eliosFiltro(body: eliosFiltroDTO): Observable<Contestazioni_eliosDTO[]> {
    return this.http.post<Contestazioni_eliosDTO[]>(this.basePath + '/select', body)
  }

  getReparto(){}
}
