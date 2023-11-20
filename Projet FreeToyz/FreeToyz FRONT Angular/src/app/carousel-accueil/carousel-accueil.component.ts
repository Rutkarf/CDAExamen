// carousel.component.ts
import { Component, OnInit } from '@angular/core';
import { ToyService } from 'src/services/toy.service';

@Component({
  selector: 'app-carousel-accueil',
  templateUrl: './carousel-accueil.component.html',
  styleUrls: ['./carousel-accueil.component.css'],
})
export class CarouselAccueilComponent implements OnInit {
  toys: any[] = [];

  constructor(private toyService: ToyService) {}

  ngOnInit(): void {
    this.toyService.toys$.subscribe((toys: any[]) => {
      this.toys = toys;
    });
  }
}