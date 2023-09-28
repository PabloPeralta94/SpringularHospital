import { Component } from '@angular/core';
import { RecetasService } from 'src/app/services/recetas.service';
import { Receta } from 'src/app/interfaces/receta';

@Component({
  selector: 'app-crear-receta',
  templateUrl: './crear-receta.component.html',
  styleUrls: ['./crear-receta.component.css']
})
export class CrearRecetaComponent {
  recetaId?: number;
  consultorio: string;
  med: {
    medicamentoId: number;
  };

  constructor(private recetaService: RecetasService) { }

  onSubmit() {
    const receta: Receta = {
      consultorio: this.consultorio,
      med: {
        medicamentoId: this.med.medicamentoId
      }
    };
  
    this.recetaService.createReceta(receta).subscribe(
      (createdReceta) => {
        console.log('Created Receta:', createdReceta);       
      },
      (error) => {
        console.error('Error creating turno:', error);
      }
    );
  }
  
}