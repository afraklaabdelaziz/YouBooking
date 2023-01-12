import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChamberDesponibleComponent } from './chamber-desponible.component';

describe('ChamberDesponibleComponent', () => {
  let component: ChamberDesponibleComponent;
  let fixture: ComponentFixture<ChamberDesponibleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChamberDesponibleComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ChamberDesponibleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
