import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { SharedModule } from '../shared/shared.module';
import { AreaMedicaComponent } from './area-medica/area-medica.component';
import { AreaEnfermeriaComponent } from './area-enfermeria/area-enfermeria.component';
import { AreaPacientesComponent } from './area-pacientes/area-pacientes.component';
import { AreaFarmaceuticaComponent } from './area-farmaceutica/area-farmaceutica.component';
import { AreaAdministrativaComponent } from './area-administrativa/area-administrativa.component';
import { AreaDirectivaComponent } from './area-directiva/area-directiva.component';
import { TurnosPendientesComponent } from './area-medica/turnos-pendientes/turnos-pendientes.component';
import { FormsModule } from '@angular/forms';
import { SolicitarTurnosComponent } from './area-pacientes/solicitar-turnos/solicitar-turnos.component';
import { EmpleadosComponent } from './area-administrativa/empleados/empleados.component';
import { PacientesComponent } from './area-administrativa/pacientes/pacientes.component';
import { VentasComponent } from './area-farmaceutica/ventas/ventas.component';
import { RecetasComponent } from './area-farmaceutica/recetas/recetas.component';



@NgModule({
  declarations: [
    AreaMedicaComponent,
    AreaEnfermeriaComponent,
    AreaPacientesComponent,
    AreaFarmaceuticaComponent,
    AreaAdministrativaComponent,
    AreaDirectivaComponent,
    TurnosPendientesComponent,
    SolicitarTurnosComponent,
    EmpleadosComponent,
    PacientesComponent,
    VentasComponent,
    RecetasComponent 
   
  ],
  imports: [
    CommonModule,
    RouterModule,
    SharedModule,
    FormsModule
  ]
})
export class PagesModule { }
