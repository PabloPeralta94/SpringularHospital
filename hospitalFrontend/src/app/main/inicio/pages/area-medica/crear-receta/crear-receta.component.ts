import { Component } from '@angular/core';
import { RecetasService } from 'src/app/services/recetas.service';
import { Receta } from 'src/app/shared/interfaces/receta';

@Component({
  selector: 'app-crear-receta',
  templateUrl: './crear-receta.component.html',
  styleUrls: ['./crear-receta.component.css']
})
export class CrearRecetaComponent {
  recetaId?: number;
  consultorio: string;
  medicamentoId: number;


  constructor(private recetaService: RecetasService) { }

  onSubmit() {
    const receta: Receta = {
      consultorio: this.consultorio,
      medicamentoId: this.medicamentoId
    };

    this.recetaService.createReceta(receta).subscribe(
      (createdReceta) => {
        this.consultorio = "";
        this.medicamentoId = 0;
        alert("Receta Creada con Exito");
        console.log('Created Receta:', createdReceta);
      },
      (error) => {
        console.error('Error creating turno:', error);
      }
    );
  }
}