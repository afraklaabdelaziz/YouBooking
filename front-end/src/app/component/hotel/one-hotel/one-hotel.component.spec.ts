import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OneHotelComponent } from './one-hotel.component';

describe('OneHotelComponent', () => {
  let component: OneHotelComponent;
  let fixture: ComponentFixture<OneHotelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OneHotelComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OneHotelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
