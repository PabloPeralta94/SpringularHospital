import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AreaPacientesComponent } from './area-pacientes.component';

describe('AreaPacientesComponent', () => {
  let component: AreaPacientesComponent;
  let fixture: ComponentFixture<AreaPacientesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AreaPacientesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AreaPacientesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
