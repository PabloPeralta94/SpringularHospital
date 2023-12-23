import { Component } from '@angular/core';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent {
  buttonData = [
    {
      title: 'Consultorios',
      description: 'Ingresa aqui para ver los consultorios o solicitar un turno',
      link: '/medica',
    },
    {
      title: 'Enfermeria',
      description: 'Ingresa aqui para ver las tareas pendientes de las enfermeras o ingresar una nueva tarea.',
      link: '/enfermeria',
    },
    {
      title: 'Mis Datos',
      description: 'Aqui pueden ingresar pacientes',
      link: '/pacientes',
    },
    {
      title: 'Farmacia',
      description: 'Ingresa aqui para comprar los medicamentos que necesitas.',
      link: '/farmacia',
    },   
    {
      title: 'Administrar empleados',
      description: 'Si estas viendo esto y no has iniciado como administrador, por favor informa del problema de inmediato.',
      link: '/administracion',
    },
    {
      title: 'Documentación',
      description: 'Documentación del proyecto e información personal del creador',
      link: '/documentación',
    },  
  ];
}
