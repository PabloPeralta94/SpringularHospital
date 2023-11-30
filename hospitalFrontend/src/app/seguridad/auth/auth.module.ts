import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegistroComponent } from './registro/registro.component';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { SharedModule } from 'src/app/shared/shared.module';
import { LoginComponent } from './login/login.component';
import { RegistroPopupComponent } from './registro-popup/registro-popup.component';



@NgModule({
  declarations: [
    LoginComponent,
    RegistroComponent,
    RegistroPopupComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    SharedModule,
    RouterModule
  ],
  exports: [
    RegistroComponent,
    LoginComponent
  ]
})
export class AuthModule { }
