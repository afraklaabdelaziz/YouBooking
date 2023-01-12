import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StatisticOwnerComponent } from './statistic-owner.component';

describe('StatisticOwnerComponent', () => {
  let component: StatisticOwnerComponent;
  let fixture: ComponentFixture<StatisticOwnerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StatisticOwnerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StatisticOwnerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
