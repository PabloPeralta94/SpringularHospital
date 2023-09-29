import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainComponent } from './landing/main.component';
import { LoginComponent } from './auth/login/login.component';
import { RegistroComponent } from './auth/registro/registro.component';
import { ProdGuardService as guard } from './guards/emp-guard.service';
import { LoginGuard } from './guards/login.guard';
import { InicioComponent } from './index/inicio/inicio.component';
import { AreaMedicaComponent } from './pages/area-medica/area-medica.component';
import { AreaEnfermeriaComponent } from './pages/area-enfermeria/area-enfermeria.component';
import { AreaFarmaceuticaComponent } from './pages/area-farmaceutica/area-farmaceutica.component';
import { AreaAdministrativaComponent } from './pages/area-administrativa/area-administrativa.component';
import { AreaDirectivaComponent } from './pages/area-directiva/area-directiva.component';
import { AreaPacientesComponent } from './pages/area-pacientes/area-pacientes.component';
import { TurnosPendientesComponent } from './pages/area-medica/turnos-pendientes/turnos-pendientes.component';
import { SolicitarTurnosComponent } from './pages/area-pacientes/solicitar-turnos/solicitar-turnos.component';
import { VentasComponent } from './pages/area-farmaceutica/ventas/ventas.component';
import { CrearRecetaComponent } from './pages/area-medica/crear-receta/crear-receta.component';


const routes: Routes = [
  { path: '', component: MainComponent }, 
  { path: 'login', component: LoginComponent },
  { path: 'registro', component: RegistroComponent },
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
  {path: 'recetas/crear', component: CrearRecetaComponent}


];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
