// button.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ButtonService {
  constructor(private http: HttpClient) {}

  getButtonData(): Observable<any> {
    return this.http.get<any>('http://votre-api-java/endpoint-pour-les-boutons');
  }
}