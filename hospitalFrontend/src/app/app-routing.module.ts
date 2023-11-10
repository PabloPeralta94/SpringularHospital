import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainComponent } from './landing/main.component';
import { InicioComponent } from './main/inicio/inicio.component';
import { AreaAdministrativaComponent } from './main/inicio/pages/area-administrativa/area-administrativa.component';
import { AreaDirectivaComponent } from './main/inicio/pages/area-directiva/area-directiva.component';
import { AreaEnfermeriaComponent } from './main/inicio/pages/area-enfermeria/area-enfermeria.component';
import { AreaFarmaceuticaComponent } from './main/inicio/pages/area-farmaceutica/area-farmaceutica.component';
import { ComprarComponent } from './main/inicio/pages/area-farmaceutica/comprar/comprar.component';
import { RecetasComponent } from './main/inicio/pages/area-farmaceutica/recetas/recetas.component';
import { VentasComponent } from './main/inicio/pages/area-farmaceutica/ventas/ventas.component';
import { AreaMedicaComponent } from './main/inicio/pages/area-medica/area-medica.component';
import { CrearRecetaComponent } from './main/inicio/pages/area-medica/crear-receta/crear-receta.component';
import { TurnosPendientesComponent } from './main/inicio/pages/area-medica/turnos-pendientes/turnos-pendientes.component';
import { AreaPacientesComponent } from './main/inicio/pages/area-pacientes/area-pacientes.component';
import { MostrarTurnosPacienteComponent } from './main/inicio/pages/area-pacientes/mostrar-turnos-paciente/mostrar-turnos-paciente.component';
import { SolicitarTurnosComponent } from './main/inicio/pages/area-pacientes/solicitar-turnos/solicitar-turnos.component';
import { LoginComponent } from './seguridad/auth/login/login.component';
import { RegistroComponent } from './seguridad/auth/registro/registro.component';


const routes: Routes = [
  {path: '', component: MainComponent }, 
  {path: 'login', component: LoginComponent },
  {path: 'registro', component: RegistroComponent },
  {path: 'index', component: InicioComponent/*,  canActivate: [LoginGuard]*/},
  {path: 'medica', component: AreaMedicaComponent},
  {path: 'enfermeria', component: AreaEnfermeriaComponent},
  {path: 'farmacia', component: AreaFarmaceuticaComponent},
  {path: 'administracion', component: AreaAdministrativaComponent},
  {path: 'direccion', component: AreaDirectivaComponent},
  {path: 'pacientes', component: AreaPacientesComponent},
  {path: 'turnospen', component: TurnosPendientesComponent},  
  {path: 'solicturno', component: SolicitarTurnosComponent},
  {path: 'ventas', component: VentasComponent},
  {path: 'comprar', component: ComprarComponent},
  {path: 'recetas/crear', component: CrearRecetaComponent},
  {path: 'recetas', component: RecetasComponent},
  {path: 'misturno', component: MostrarTurnosPacienteComponent}


];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
