import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { TareasService } from 'src/app/services/tareas.service';

@Component({
  selector: 'app-crear-tarea',
  templateUrl: './crear-tarea.component.html',
  styleUrls: ['./crear-tarea.component.css']
})
export class CrearTareaComponent {
  tareaForm: FormGroup;

  constructor(private fb: FormBuilder, private tareaService: TareasService) {
    this.initializeForm();
  }

  initializeForm() {
    this.tareaForm = this.fb.group({
      nombre: ['', Validators.required],
      fechaInicio: [null],
      fechaFin: [null],
      enfermeraAsignada: ['', Validators.required],
      estado: [''],
      prioridad: ['', Validators.required],
      pacienteAsociado: ['', Validators.required],
      ubicacion: ['', Validators.required],
      notas: [''],
    });
  }

  onSubmit() {
    if (this.tareaForm.valid) {
      const tareaData = this.tareaForm.value;
      this.tareaService.createTarea(tareaData).subscribe(
        (response) => {
          console.log('Tarea created successfully:', response);
          // Optionally, you can navigate to another page or perform any other action.
        },
        (error) => {
          console.error('Error creating Tarea:', error);
        }
      );
    }
  }
}
