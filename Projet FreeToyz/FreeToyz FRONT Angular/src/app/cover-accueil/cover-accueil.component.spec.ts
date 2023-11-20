import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoverAccueilComponent } from './cover-accueil.component';

describe('CoverAccueilComponent', () => {
  let component: CoverAccueilComponent;
  let fixture: ComponentFixture<CoverAccueilComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CoverAccueilComponent]
    });
    fixture = TestBed.createComponent(CoverAccueilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
