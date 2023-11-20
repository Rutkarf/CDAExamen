// navbar-search-toy.component.ts
import { Component } from '@angular/core';
import { ToyService } from 'src/services/toy.service';

@Component({
  selector: 'app-navbar-search-toy',
  templateUrl: './navbar-search-toy.component.html',
  styleUrls: ['./navbar-search-toy.component.css'],
})
export class NavbarSearchToyComponent {
  constructor(private toyService: ToyService) {}

  showToys(category: string): void {
    this.toyService.getToysByCategory(category);
  }
}


