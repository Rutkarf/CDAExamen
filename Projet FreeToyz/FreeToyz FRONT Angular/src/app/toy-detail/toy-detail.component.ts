// toy-detail.component.ts

import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-toy-detail',
  templateUrl: './toy-detail.component.html',
  styleUrls: ['./toy-detail.component.css']
})
export class ToyDetailComponent {
  @Input() selectedToy: any; // Assure-toi que la propriété selectedToy est bien décorée avec @Input()

  constructor() { }
}