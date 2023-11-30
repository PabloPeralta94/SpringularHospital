import { Component, OnInit } from '@angular/core';
import { UsuariosService } from 'src/app/services/usuarios.service';
import { UsuarioDto } from 'src/app/shared/interfaces/usuario-dto';

@Component({
  selector: 'app-ver-empleados',
  templateUrl: './ver-empleados.component.html',
  styleUrls: ['./ver-empleados.component.css']
})
export class VerEmpleadosComponent implements OnInit {
  usuarios: UsuarioDto[] = [];
  filteredUsuarios: UsuarioDto[] = [];
  mensaje: string = "";
  page = 0;
  size = 4;
  totalElements = 0;  
  allRoles: string[] = ['ROLE_MEDIC', 'ROLE_NURSE', 'ROLE_PHARMA', 'ROLE_ADMIN', 'ROLE_DIRECTOR', 'ROLE_USER'];
  selectedRole: string = '';

  constructor(private usuariosService: UsuariosService) {}

  ngOnInit(): void {
    this.loadUsuarios();
  }

  loadUsuarios() {
    if (this.selectedRole) {
      this.usuariosService.getUsuariosByRole(this.selectedRole, this.page, this.size).subscribe(
        (data) => {
          if (data && data.content) {
            console.log('Data received:', data);
            this.usuarios = data.content;
            this.totalElements = data.totalElements;
            console.log('Usuarios:', this.usuarios);
            this.filteredUsuarios = [...this.usuarios];
            this.mensaje= "";
          } else {
            console.error('Invalid data received:', data);
            this.usuarios = [];
            this.filteredUsuarios = [];
            this.mensaje = "No se encontraron usuarios con ese rol.";
          }
        }        
      );
    } else {
      this.usuariosService.getAllUsuarios(this.page, this.size).subscribe(
        (data) => {
          console.log('Data received:', data);
          this.usuarios = data.content;
          this.totalElements = data.totalElements;
          console.log('Usuarios:', this.usuarios);
          this.filteredUsuarios = [...this.usuarios];
          this.mensaje= "";
        },
        (error) => {
          console.error('Error:', error);
          this.usuarios = []; 
          this.filteredUsuarios = [];
          this.mensaje = "No se encontraron usuarios con ese rol."
        }
      );
    }
  }

  filterByRole() {
    this.page = 0;
    this.loadUsuarios();
  }

  nextPage() {
    if (this.page < this.totalPages - 1) {
      this.page++;
      this.loadUsuarios();
    }
  }

  previousPage() {
    if (this.page > 0) {
      this.page--;
      this.loadUsuarios();
    }
  }

  get totalPages(): number {
    return Math.ceil(this.totalElements / this.size);
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