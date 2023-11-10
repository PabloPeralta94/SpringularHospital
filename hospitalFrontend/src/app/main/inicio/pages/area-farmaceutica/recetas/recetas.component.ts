import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { Receta } from 'src/app/interfaces/receta';
import { MedicamentosService } from 'src/app/services/medicamentos.service';
import { RecetasService } from 'src/app/services/recetas.service';

@Component({
  selector: 'app-recetas',
  templateUrl: './recetas.component.html',
  styleUrls: ['./recetas.component.css']
})
export class RecetasComponent {
  public recetas: Receta[] = [];

  constructor(
    private recetasService: RecetasService,
    private medicamentosService: MedicamentosService
    ) { }

  ngOnInit() {
    this.getRecetas();
    
  }    
  
  


  public getRecetas(): void {
    this.recetasService.getRecetas().subscribe(
      (response: Receta[]) => {
        this.recetas = response.sort((a, b) => b.recetaId! - a.recetaId!);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

}
