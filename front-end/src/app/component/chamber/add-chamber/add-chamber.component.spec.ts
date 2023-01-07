import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddChamberComponent } from './add-chamber.component';

describe('AddChamberComponent', () => {
  let component: AddChamberComponent;
  let fixture: ComponentFixture<AddChamberComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddChamberComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddChamberComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
