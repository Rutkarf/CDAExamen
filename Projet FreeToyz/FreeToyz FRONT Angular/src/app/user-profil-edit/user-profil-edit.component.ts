// user-profil-edit.component.ts

import { Component } from '@angular/core';
import { User } from './user.model'; // Assurez-vous que le chemin est correct // Import your user model

@Component({
  selector: 'app-user-profil-edit',
  templateUrl: './user-profil-edit.component.html',
  styleUrls: ['./user-profil-edit.component.css']
})
export class UserProfilEditComponent {
  user: User = {
    name: '', // Initialize with appropriate default values
    email: '',
    location: ''
  };

  // Other component logic goes here
}