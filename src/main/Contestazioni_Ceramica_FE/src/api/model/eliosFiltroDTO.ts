export interface eliosFiltroDTO {
    id: number;
    data_creazione: Date;
    data_ultima_mod: Date | null;
    cod_articolo: string;
    rs_cliente: string;
    stato: string;
    reparto: string;
    formato: string;
    utente_creazione: string;
}
