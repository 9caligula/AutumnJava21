import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogObjectTypeComponent } from './dialog-object-type.component';

describe('DialogObjectTypeComponent', () => {
  let component: DialogObjectTypeComponent;
  let fixture: ComponentFixture<DialogObjectTypeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DialogObjectTypeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogObjectTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
