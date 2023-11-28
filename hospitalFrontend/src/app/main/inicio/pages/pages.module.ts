import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { AreaMedicaComponent } from './area-medica/area-medica.component';
import { AreaEnfermeriaComponent } from './area-enfermeria/area-enfermeria.component';
import { AreaPacientesComponent } from './area-pacientes/area-pacientes.component';
import { AreaFarmaceuticaComponent } from './area-farmaceutica/area-farmaceutica.component';
import { AreaAdministrativaComponent } from './area-administrativa/area-administrativa.component';
import { TurnosPendientesComponent } from './area-medica/turnos-pendientes/turnos-pendientes.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SolicitarTurnosComponent } from './area-pacientes/solicitar-turnos/solicitar-turnos.component';
import { EmpleadosComponent } from './area-administrativa/empleados/empleados.component';
import { CrearRecetaComponent } from './area-medica/crear-receta/crear-receta.component';
import { ComprarComponent } from './area-farmaceutica/comprar/comprar.component';
import { MostrarTurnosPacienteComponent } from './area-pacientes/mostrar-turnos-paciente/mostrar-turnos-paciente.component';
import { VerTareasComponent } from './area-enfermeria/ver-tareas/ver-tareas.component';
import { CrearTareaComponent } from './area-enfermeria/crear-tarea/crear-tarea.component';
import { VerEmpleadosComponent } from './area-administrativa/empleados/ver-empleados/ver-empleados.component';
import { EditarEmpleadosComponent } from './area-administrativa/empleados/editar-empleados/editar-empleados.component';
import { SharedModule } from 'src/app/shared/shared.module';






@NgModule({
  declarations: [
    AreaMedicaComponent,
    AreaEnfermeriaComponent,
    AreaPacientesComponent,
    AreaFarmaceuticaComponent,
    AreaAdministrativaComponent,      
    SolicitarTurnosComponent,
    EmpleadosComponent,    
    CrearRecetaComponent,
    ComprarComponent,
    MostrarTurnosPacienteComponent,
    VerTareasComponent,
    CrearTareaComponent,
    VerEmpleadosComponent,
    EditarEmpleadosComponent,
    TurnosPendientesComponent    
   
  ],
  imports: [
    CommonModule,
    RouterModule,
    SharedModule,
    FormsModule,
    ReactiveFormsModule,
       

  ]
})
export class PagesModule { }
