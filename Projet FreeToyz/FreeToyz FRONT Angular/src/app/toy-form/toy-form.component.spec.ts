import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ToyFormComponent } from './toy-form.component';

describe('ToyFormComponent', () => {
  let component: ToyFormComponent;
  let fixture: ComponentFixture<ToyFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ToyFormComponent]
    });
    fixture = TestBed.createComponent(ToyFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
