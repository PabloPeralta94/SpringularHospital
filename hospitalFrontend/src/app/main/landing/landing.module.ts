import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LandingComponent } from './landing.component';
import { SharedModule } from '../../shared/shared.module';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { RouterModule } from '@angular/router';
import { AuthModule } from '../../seguridad/auth/auth.module';
import { MatDialogModule } from '@angular/material/dialog';



@NgModule({
  declarations: [
    LandingComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    FontAwesomeModule,
    AuthModule,
    RouterModule,
    MatDialogModule
  ]
})
export class LandingModule { }
