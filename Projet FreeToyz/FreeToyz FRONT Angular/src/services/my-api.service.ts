import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class MyApiService {
  private apiUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  // Exemple de méthode pour récupérer toutes les données
  getAllData() {
    return this.http.get(`${this.apiUrl}/data`);
  }

  // Exemple de méthode pour récupérer une seule donnée par ID
  getDataById(id: number) {
    return this.http.get(`${this.apiUrl}/data/${id}`);
  }

  // Exemple de méthode pour ajouter une nouvelle donnée
  addData(newData: any) {
    return this.http.post(`${this.apiUrl}/data`, newData);
  }

  // Exemple de méthode pour mettre à jour une donnée existante par ID
  updateDataById(id: number, updatedData: any) {
    return this.http.put(`${this.apiUrl}/data/${id}`, updatedData);
  }

  // Exemple de méthode pour supprimer une donnée par ID
  deleteDataById(id: number) {
    return this.http.delete(`${this.apiUrl}/data/${id}`);
  }

  // Ajoutez d'autres méthodes selon les besoins de votre API
}

