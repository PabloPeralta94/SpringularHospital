import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

import { MenuComponent } from './menu/menu.component';




@NgModule({
  declarations: [
   MenuComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    FontAwesomeModule
  ],
  exports: [
    MenuComponent    
  ]
})
export class SharedModule { }
