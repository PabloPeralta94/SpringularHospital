import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InicioComponent } from './inicio/inicio.component';
import { RouterModule } from '@angular/router';
import { SharedModule } from '../shared/shared.module';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { MatButtonModule } from '@angular/material/button';




@NgModule({
  declarations: [
    InicioComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    SharedModule,
    FontAwesomeModule,
    MatButtonModule
  ]
})
export class IndexModule { }
