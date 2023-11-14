import { Component, OnInit } from '@angular/core';
import { UsuarioDto } from 'src/app/interfaces/usuario-dto';
import { UsuariosService } from 'src/app/services/usuarios.service';

@Component({
  selector: 'app-ver-empleados',
  templateUrl: './ver-empleados.component.html',
  styleUrls: ['./ver-empleados.component.css']
})
export class VerEmpleadosComponent implements OnInit {

  usuarios: UsuarioDto[] = [];

  constructor(private usuariosService: UsuariosService) { }

  ngOnInit(): void {
    this.usuariosService.getAllUsuarios().subscribe(data => {
      this.usuarios = data;
    });
  }

  getImageForRole(roleName: string): string {    
    const roleImageMap: { [key: string]: string } = {
      'ROLE_MEDIC': 'medic.png',
      'ROLE_NURSE': 'nurse.png',
      'ROLE_PHARMA': 'pharma.png',
      'ROLE_ADMIN': 'admin.png',
      'ROLE_DIRECTOR': 'director.png',
      'ROLE_USER': 'user.png'
      
    }; 
    
    return roleImageMap[roleName] || 'user.png'; 
  }
}