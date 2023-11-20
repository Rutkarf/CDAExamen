// toy-list.component.ts

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-toy-list',
  templateUrl: './toy-list.component.html',
  styleUrls: ['./toy-list.component.css']
})
export class ToyListComponent implements OnInit {
  // Assure-toi d'avoir une propriété `toys` dans ton composant
  // qui contient la liste des jouets à afficher.
  toys: any[] = [
    { name: 'Toy 1', image: 'assets/upload/LOGOFreeToyzOriginel.jpg', description: 'Description of Toy 1', owner: 'Parent 1' },
    { name: 'Toy 2', image: 'assets/upload/LOGOFreeToyzOriginel.jpg', description: 'Description of Toy 2', owner: 'Parent 2' },
    // Ajoute d'autres jouets selon tes besoins
  ];

  constructor() { }

  ngOnInit(): void {
    // Logique d'initialisation, si nécessaire
  }

}

