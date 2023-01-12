import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OneRoomComponent } from './one-room.component';

describe('OneRoomComponent', () => {
  let component: OneRoomComponent;
  let fixture: ComponentFixture<OneRoomComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OneRoomComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OneRoomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
