import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainComponent } from './main.component';
import { SharedModule } from '../shared/shared.module';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { AuthModule } from '../auth/auth.module';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [
    MainComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    FontAwesomeModule,
    AuthModule,
    RouterModule
  ]
})
export class LandingModule { }
