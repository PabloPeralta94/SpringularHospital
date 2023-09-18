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
  {path: 'pacientes', component: AreaPacientesComponent}


];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
