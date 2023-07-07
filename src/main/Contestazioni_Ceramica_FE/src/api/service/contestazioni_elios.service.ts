import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Contestazioni_eliosDTO } from '../model/contesatzioni_eliosDTO';
import { Observable } from 'rxjs';

@Injectable()
export class contestazioniEliosservice {
  static getContesatzioni_elios: any;
  getContestazioni() {
    throw new Error('Method not implemented.');
  }
  protected basePath = 'http://localhost:8080/elios';
  constructor(private http: HttpClient) {}

  getContesatzioni_elios():Observable<Contestazioni_eliosDTO[]>  {
    return this.http.get<Contestazioni_eliosDTO[]>(this.basePath + '/select');
  }
}
