import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReservationListOncoursComponent } from './reservation-list-oncours.component';

describe('ReservationListOncoursComponent', () => {
  let component: ReservationListOncoursComponent;
  let fixture: ComponentFixture<ReservationListOncoursComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReservationListOncoursComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReservationListOncoursComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
