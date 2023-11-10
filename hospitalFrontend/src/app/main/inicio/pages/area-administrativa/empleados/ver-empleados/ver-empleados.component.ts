import { Component } from '@angular/core';

@Component({
  selector: 'app-ver-empleados',
  templateUrl: './ver-empleados.component.html',
  styleUrls: ['./ver-empleados.component.css']
})
export class VerEmpleadosComponent {

  workers = [
    {
      name: 'John Doe',
      position: 'Manager',
      age: 35,
      salary: 60000
    },
    {
      name: 'Jane Smith',
      position: 'Engineer',
      age: 28,
      salary: 50000
    },
    {
      name: 'Mike Johnson',
      position: 'Technician',
      age: 40,
      salary: 45000
    },
    {
      name: 'Sarah Brown',
      position: 'Designer',
      age: 30,
      salary: 55000
    },
    {
      name: 'David Wilson',
      position: 'Analyst',
      age: 32,
      salary: 58000
    }
  ];

}
