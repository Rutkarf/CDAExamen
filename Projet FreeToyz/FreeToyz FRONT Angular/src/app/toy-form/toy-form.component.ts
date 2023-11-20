// toy-form.component.ts

import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-toy-form',
  templateUrl: './toy-form.component.html',
  styleUrls: ['./toy-form.component.css']
})
export class ToyFormComponent {
  @Input() toy: any; // Assure-toi d'avoir une structure de données correspondante
  @Input() formTitle!: string;
  @Input() submitButtonText!: string;
  @Output() submitForm: EventEmitter<any> = new EventEmitter();

  onSubmit() {
    this.submitForm.emit(this.toy);
  }
}