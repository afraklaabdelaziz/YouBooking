import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OwnerReservationListComponent } from './owner-reservation-list.component';

describe('OwnerReservationListComponent', () => {
  let component: OwnerReservationListComponent;
  let fixture: ComponentFixture<OwnerReservationListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OwnerReservationListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OwnerReservationListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
