import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CorreoComponent } from './correo.component';

describe('CorreoComponent', () => {
  let component: CorreoComponent;
  let fixture: ComponentFixture<CorreoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CorreoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CorreoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
