// Importe les modules nécessaires depuis Angular
import { Component, OnInit } from '@angular/core';

// Définit le composant Angular avec son sélecteur, son template et son style
@Component({
  selector: 'app-toys',
  templateUrl: './toys.component.html',
  styleUrls: ['./toys.component.css']  // N'oublie pas d'ajuster ce chemin si nécessaire
})

// Exporte la classe du composant
export class ToysComponent implements OnInit {
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
  // Déclare une propriété pour stocker la liste des jouets
  
}