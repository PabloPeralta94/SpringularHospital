import { Component } from '@angular/core';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent {
  buttonData = [
    {
      title: 'Area Medica',
      description: 'Aqui pueden ingresar los medicos',
      link: '/medica',
    },
    {
      title: 'Area Enfermeria',
      description: 'Aqui pueden ingresar los enfermeros',
      link: '/enfermeria',
    },
    {
      title: 'Area Pacientes',
      description: 'Aqui pueden ingresar pacientes',
      link: '/pacientes',
    },
    {
      title: 'Area Farmacia',
      description: 'Aqui pueden ingresar farmaceuticos',
      link: '/farmacia',
    },
    {
      title: 'Area Directiva',
      description: 'Aqui pueden ingresar directivos',
      link: '/direccion',
    },
    {
      title: 'Area Administrativa',
      description: 'Aqui pueden ingresar administrativos',
      link: '/administracion',
    },
    // Agregar mas botones de ser necesario.
  ];
}
