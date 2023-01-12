import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelsOwnerComponent } from './hotels-owner.component';

describe('HotelsOwnerComponent', () => {
  let component: HotelsOwnerComponent;
  let fixture: ComponentFixture<HotelsOwnerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HotelsOwnerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HotelsOwnerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
