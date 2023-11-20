import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarSearchToyComponent } from './navbar-search-toy.component';

describe('NavbarSearchToyComponent', () => {
  let component: NavbarSearchToyComponent;
  let fixture: ComponentFixture<NavbarSearchToyComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NavbarSearchToyComponent]
    });
    fixture = TestBed.createComponent(NavbarSearchToyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
