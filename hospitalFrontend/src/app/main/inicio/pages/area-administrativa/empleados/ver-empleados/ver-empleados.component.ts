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
  filteredUsuarios: UsuarioDto[] = [];
  page = 0;
  size = 4;
  totalElements = 0;
  allRoles: string[] = []; 
  selectedRole: string = '';

  constructor(private usuariosService: UsuariosService) {}

  ngOnInit(): void {
    this.loadUsuarios();
  }

  loadUsuarios() {
    this.usuariosService.getAllUsuarios(this.page, this.size).subscribe(
      (data) => {
        console.log('Data received:', data);
        this.usuarios = data.content;
        this.totalElements = data.totalElements;
        console.log('Usuarios:', this.usuarios);
        console.log('Total Elements:', this.totalElements);
        this.extractRoles(); 
        this.filteredUsuarios = [...this.usuarios];
      },
      (error) => {
        console.error('Error:', error);
      }
    );
  }

  extractRoles() {  
    const rolesSet = new Set<string>();
    this.usuarios.forEach((usuario) => {
      usuario.roles.forEach((rol) => rolesSet.add(rol.rolNombre));
    });
    this.allRoles = Array.from(rolesSet);
  }

  filterByRole() {
    const selectedRole: string = this.selectedRole;
    if (!selectedRole) {
      this.filteredUsuarios = [...this.usuarios];
    } else {
      this.filteredUsuarios = this.usuarios.filter((usuario) =>
        usuario.roles.some((rol) => rol.rolNombre === selectedRole)
      );
    }
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
