// login.component.ts

import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string = '';
  password: string = '';

  onSubmit() {
    // Ajoute la logique de traitement du formulaire de connexion ici
    console.log(`Username: ${this.username}, Password: ${this.password}`);
  }
}