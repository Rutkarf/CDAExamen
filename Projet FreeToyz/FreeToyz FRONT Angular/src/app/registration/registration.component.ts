// registration.component.ts

import { Component } from '@angular/core';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {
  user: any = { // Assure-toi d'avoir une structure de données correspondante
    username: '',
    email: '',
    password: '',
    confirmPassword: ''
    // Ajoute d'autres propriétés selon tes besoins
  };

  onSubmit() {
    // Ajoute la logique de traitement du formulaire d'inscription ici
    console.log('User registered:', this.user);
  }
}