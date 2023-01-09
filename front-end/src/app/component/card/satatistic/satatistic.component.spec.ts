import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SatatisticComponent } from './satatistic.component';

describe('SatatisticComponent', () => {
  let component: SatatisticComponent;
  let fixture: ComponentFixture<SatatisticComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SatatisticComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SatatisticComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
