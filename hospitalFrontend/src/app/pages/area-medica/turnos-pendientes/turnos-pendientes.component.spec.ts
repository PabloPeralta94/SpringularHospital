import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TurnosPendientesComponent } from './turnos-pendientes.component';

describe('TurnosPendientesComponent', () => {
  let component: TurnosPendientesComponent;
  let fixture: ComponentFixture<TurnosPendientesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TurnosPendientesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TurnosPendientesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
