export interface eliosFiltroDTO {
    id: number;
    data_creazione: string;
    data_ultima_mod: string | null;
    cod_articolo: string;
    rs_cliente: string; //NOT NULL
    stato: string;
    reparto: string; //NOT NULL
    formato: string; //NOT NULL
    utente_creazione: string;
}
