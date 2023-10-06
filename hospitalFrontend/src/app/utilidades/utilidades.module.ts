import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MedicamentosComponent } from './medicamentos/medicamentos.component';
import { MedicamentoComponent } from './medicamento/medicamento.component';
import { ComprasComponent } from './compras/compras.component';



@NgModule({
  declarations: [
    MedicamentosComponent,
    MedicamentoComponent,
    ComprasComponent
  ],
  imports: [
    CommonModule
  ]
})
export class UtilidadesModule { }
