// search.component.ts

import { Component } from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent {
  searchTerm: string = '';
  searchResults: any[] = []; // Assure-toi d'avoir une structure de données correspondante

  onSearch() {
    // Ajoute la logique de recherche ici, par exemple, en utilisant un service Angular pour obtenir les résultats
    // Exemple:
    // this.searchResults = this.mySearchService.search(this.searchTerm);
  }
}
