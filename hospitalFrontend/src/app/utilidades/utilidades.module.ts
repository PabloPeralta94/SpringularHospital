import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MedicamentosComponent } from './medicamentos/medicamentos.component';
import { MedicamentoComponent } from './medicamento/medicamento.component';



@NgModule({
  declarations: [
    MedicamentosComponent,
    MedicamentoComponent
  ],
  imports: [
    CommonModule
  ]
})
export class UtilidadesModule { }
