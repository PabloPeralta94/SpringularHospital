import { Component } from '@angular/core';
import { TareasService } from 'src/app/services/tareas.service';

@Component({
  selector: 'app-crear-tarea',
  templateUrl: './crear-tarea.component.html',
  styleUrls: ['./crear-tarea.component.css']
})
export class CrearTareaComponent {
  
  tareaNombre: string;	    
  tareaDescripcion: string;      
  tareaEnfermeraAsignada: string;
  tareaPrioridad: string;
  tareaPacienteAsociado: string;
  tareaUbicacion: string;
  tareaNotas: string;     

  constructor(private tareaService: TareasService) { }

  onSubmit() {
    const tarea = {
      nombre: this.tareaNombre,
      descripcion: this.tareaDescripcion,
      enfermeraAsignada: this.tareaEnfermeraAsignada,
      prioridad: this.tareaPrioridad,
      pacienteAsociado: this.tareaPacienteAsociado,
      ubicacion: this.tareaUbicacion,
      notas: this.tareaNotas
    };

    this.tareaService.createTarea(tarea).subscribe(
      (createdTarea) => {
        console.log('Created Tarea:', createdTarea);
        this.tareaNombre = '';
        this.tareaDescripcion = '';
        this.tareaEnfermeraAsignada = '';
        this.tareaPacienteAsociado = '';
        this.tareaPrioridad = '';
        this.tareaUbicacion = '';
        this.tareaNotas = '';
        
      },
      (error) => {
        console.error('Error creating tarea:', error);
      }
    );
  }
}