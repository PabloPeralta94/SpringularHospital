import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { MenuComponent } from './menu/menu.component';
import { ConsultorioComponent } from './inputs/consultorio/consultorio.component';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatInputModule } from '@angular/material/input';
import { MatToolbarModule } from '@angular/material/toolbar';




@NgModule({
  declarations: [
   MenuComponent,
   ConsultorioComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    FontAwesomeModule,
    MatInputModule,
    MatButtonModule,
    MatToolbarModule,
    MatCardModule
  ],
  exports: [
    MenuComponent,
    ConsultorioComponent    
  ]
})
export class SharedModule { }
