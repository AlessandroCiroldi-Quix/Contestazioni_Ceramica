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
export class FormComponent {
  onInput(event: Event): string {
    // Aggiunto tipo di ritorno "string"

    // prova del 9
    console.log((<HTMLInputElement>event.target).value);

    // ritorna il valore del input
    return (<HTMLInputElement>event.target).value; // Ritorna il valore di event.target.value
  }
}
