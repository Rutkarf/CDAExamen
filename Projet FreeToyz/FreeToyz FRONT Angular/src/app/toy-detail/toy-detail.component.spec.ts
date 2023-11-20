import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ToyDetailComponent } from './toy-detail.component';

describe('ToyDetailComponent', () => {
  let component: ToyDetailComponent;
  let fixture: ComponentFixture<ToyDetailComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ToyDetailComponent]
    });
    fixture = TestBed.createComponent(ToyDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
