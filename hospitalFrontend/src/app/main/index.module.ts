import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { SharedModule } from '../shared/shared.module';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { MatButtonModule } from '@angular/material/button';
import { InicioComponent } from './index/inicio.component';




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
