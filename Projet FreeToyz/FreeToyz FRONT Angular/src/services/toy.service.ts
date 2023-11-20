// toy.service.ts
import { BehaviorSubject } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ToyService {
  toys$: any;
  getToysByCategory(category: string) {
    throw new Error('Method not implemented.');
  }
  private toysSubject: BehaviorSubject<any[]> = new BehaviorSubject<any[]>([]);

  // ...

  updateToys() {
    const toys: any[] = []; // Remplacez YourType par le type réel de vos jouets
    this.toysSubject.next(toys);
  }
}

