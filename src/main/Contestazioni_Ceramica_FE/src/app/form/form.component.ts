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
  onInput(event: Event): void {
    // diciamo a TS che questo è un input HTML
    console.log((<HTMLInputElement>event.target).value); //! Casting necessario

    //? Ora questo event (variabile che contiene il valore digitato dall'utente) deve andare a generare il service
  }
}
