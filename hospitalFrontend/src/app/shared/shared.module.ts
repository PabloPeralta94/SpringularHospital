import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { MenuComponent } from './menu/menu.component';
import { ConsultorioComponent } from './inputs/consultorio/consultorio.component';




@NgModule({
  declarations: [
   MenuComponent,
   ConsultorioComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    FontAwesomeModule
  ],
  exports: [
    MenuComponent,
    ConsultorioComponent    
  ]
})
export class SharedModule { }
