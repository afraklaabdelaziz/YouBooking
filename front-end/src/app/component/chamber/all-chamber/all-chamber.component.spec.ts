import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllChamberComponent } from './all-chamber.component';

describe('AllChamberComponent', () => {
  let component: AllChamberComponent;
  let fixture: ComponentFixture<AllChamberComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllChamberComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AllChamberComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
