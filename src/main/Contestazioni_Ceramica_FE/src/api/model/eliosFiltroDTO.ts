export interface eliosFiltroDTO {
    id: number;
    data_creazione: Date;
    data_ultima_mod: Date | null;
    cod_articolo: string;
    rs_cliente: string; //NOT NULL
    stato: string;
    reparto: string; //NOT NULL
    formato: string; //NOT NULL
    utente_creazione: string;
}