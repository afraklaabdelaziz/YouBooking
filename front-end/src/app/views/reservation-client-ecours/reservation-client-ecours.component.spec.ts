import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReservationClientEcoursComponent } from './reservation-client-ecours.component';

describe('ReservationClientEcoursComponent', () => {
  let component: ReservationClientEcoursComponent;
  let fixture: ComponentFixture<ReservationClientEcoursComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReservationClientEcoursComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReservationClientEcoursComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
