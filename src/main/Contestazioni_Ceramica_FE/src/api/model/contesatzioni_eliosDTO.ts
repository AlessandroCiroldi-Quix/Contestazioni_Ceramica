export interface Contestazioni_eliosDTO {
  id: number;
  //@NonNull
  cod_cliente: string; //NOT NULL
  rs_cliente: string; //NOT NULL
  cod_articolo: string; //NOT NULL
  tono: string; //NOT NULL
  num_fattura: string | null; //NULL
  data_fattura: Date | null; //NULL
  descrizione: string; //NOT NULL
  qta_contestata: number; //NOT NULL
  unita_misura: string; //NOT NULL
  posato: number; //NOT NULL
  stato: string; //NOT NULL
  utente_creazione: string; //NOT NULL
  data_creazione: Date; //DEFAULT CURRENT_TIMESTAMP,
  utente_ultima_mod: string | null; //NULL
  data_ultima_mod: Date | null; //DEFAULT '0000-00-00 00:00:00',
  desc_prodotto: string;
  uid_files: string | null; //NULL
  tipology: string | null; //NULL
  motivazione: string;
  company: string; //NOT NULL
  num_buono: string | null; //NULL
  num_bolla: string | null; //NULL
  num_ord_reparto: string | null; //NULL
  difettosita: string | null; //NULL
  deleted: number; //DEFAULT '0'
}
