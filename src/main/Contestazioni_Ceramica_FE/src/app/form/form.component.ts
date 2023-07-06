//? Importazioni del componente FORM
import { Component } from '@angular/core';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss'],
  standalone: true,
  imports: [
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule,
  ],
})

//? Logica del componente FORM
export class FormComponent {
  valoreID_cont: string = '';
  // Funzione che inmagazzina il valore quando digiti
  onInputID_cont(event: Event): string {
    // Aggiunto tipo di ritorno "string"

    console.log((<HTMLInputElement>event.target).value);
    this.valoreID_cont = (<HTMLInputElement>event.target).value;
    // ritorna il valore del input
    return this.valoreID_cont; // Ritorna il valore di event.target.value
  }

  // funzione che fa qualcosa quando click
  onClick() {}
}
