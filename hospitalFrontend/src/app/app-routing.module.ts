import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LandingComponent } from './main/landing/landing.component';
import { InicioComponent } from './main/index/inicio.component';
import { AreaAdministrativaComponent } from './main/index/pages/area-administrativa/area-administrativa.component';
import { AreaEnfermeriaComponent } from './main/index/pages/area-enfermeria/area-enfermeria.component';
import { AreaFarmaceuticaComponent } from './main/index/pages/area-farmaceutica/area-farmaceutica.component';
import { ComprarComponent } from './main/index/pages/area-farmaceutica/comprar/comprar.component';
import { AreaMedicaComponent } from './main/index/pages/area-medica/area-medica.component';
import { CrearRecetaComponent } from './main/index/pages/area-medica/crear-receta/crear-receta.component';
import { TurnosPendientesComponent } from './main/index/pages/area-medica/turnos-pendientes/turnos-pendientes.component';
import { AreaPacientesComponent } from './main/index/pages/area-pacientes/area-pacientes.component';
import { MostrarTurnosPacienteComponent } from './main/index/pages/area-pacientes/mostrar-turnos-paciente/mostrar-turnos-paciente.component';
import { SolicitarTurnosComponent } from './main/index/pages/area-pacientes/solicitar-turnos/solicitar-turnos.component';
import { LoginComponent } from './security/auth/login/login.component';
import { RegistroComponent } from './security/auth/registro/registro.component';


const routes: Routes = [
  {path: '', component: LandingComponent }, 
  {path: 'login', component: LoginComponent },
  {path: 'registro', component: RegistroComponent },
  {path: 'index', component: InicioComponent/*,  canActivate: [LoginGuard]*/},
  {path: 'medica', component: AreaMedicaComponent},
  {path: 'enfermeria', component: AreaEnfermeriaComponent},
  {path: 'farmacia', component: AreaFarmaceuticaComponent},
  {path: 'administracion', component: AreaAdministrativaComponent},
  {path: 'pacientes', component: AreaPacientesComponent},
  {path: 'turnospen', component: TurnosPendientesComponent},  
  {path: 'solicturno', component: SolicitarTurnosComponent},
  {path: 'comprar', component: ComprarComponent},
  {path: 'recetas/crear', component: CrearRecetaComponent},
  {path: 'misturno', component: MostrarTurnosPacienteComponent}


];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
