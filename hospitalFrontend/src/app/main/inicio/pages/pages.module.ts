import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { AreaMedicaComponent } from './area-medica/area-medica.component';
import { AreaEnfermeriaComponent } from './area-enfermeria/area-enfermeria.component';
import { AreaPacientesComponent } from './area-pacientes/area-pacientes.component';
import { AreaFarmaceuticaComponent } from './area-farmaceutica/area-farmaceutica.component';
import { AreaAdministrativaComponent } from './area-administrativa/area-administrativa.component';
import { AreaDirectivaComponent } from './area-directiva/area-directiva.component';
import { TurnosPendientesComponent } from './area-medica/turnos-pendientes/turnos-pendientes.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SolicitarTurnosComponent } from './area-pacientes/solicitar-turnos/solicitar-turnos.component';
import { EmpleadosComponent } from './area-administrativa/empleados/empleados.component';
import { PacientesComponent } from './area-administrativa/pacientes/pacientes.component';
import { VentasComponent } from './area-farmaceutica/ventas/ventas.component';
import { RecetasComponent } from './area-farmaceutica/recetas/recetas.component';
import { CrearRecetaComponent } from './area-medica/crear-receta/crear-receta.component';
import { ComprarComponent } from './area-farmaceutica/comprar/comprar.component';
import { MostrarTurnosPacienteComponent } from './area-pacientes/mostrar-turnos-paciente/mostrar-turnos-paciente.component';
import { VerTareasComponent } from './area-enfermeria/ver-tareas/ver-tareas.component';
import { CrearTareaComponent } from './area-enfermeria/crear-tarea/crear-tarea.component';
import { VerEmpleadosComponent } from './area-administrativa/empleados/ver-empleados/ver-empleados.component';
import { EditarEmpleadosComponent } from './area-administrativa/empleados/editar-empleados/editar-empleados.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { CorreoComponent } from './area-directiva/correo/correo.component';
import { QuejasComponent } from './area-directiva/quejas/quejas.component';





@NgModule({
  declarations: [
    AreaMedicaComponent,
    AreaEnfermeriaComponent,
    AreaPacientesComponent,
    AreaFarmaceuticaComponent,
    AreaAdministrativaComponent,
    AreaDirectivaComponent,    
    SolicitarTurnosComponent,
    EmpleadosComponent,
    PacientesComponent,
    VentasComponent,
    RecetasComponent,
    CrearRecetaComponent,
    ComprarComponent,
    MostrarTurnosPacienteComponent,
    VerTareasComponent,
    CrearTareaComponent,
    VerEmpleadosComponent,
    EditarEmpleadosComponent,
    TurnosPendientesComponent,
    CorreoComponent,
    QuejasComponent
   
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
