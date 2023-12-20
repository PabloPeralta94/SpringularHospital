import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
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
  mensaje: string = '';
  page = 0;
  size = 4;
  totalElements = 0;
  allRoles: string[] = ['ROLE_MEDIC', 'ROLE_NURSE', 'ROLE_PHARMA', 'ROLE_ADMIN', 'ROLE_DIRECTOR', 'ROLE_USER'];
  selectedRole: string = '';

  constructor(private usuariosService: UsuariosService) {}

  ngOnInit(): void {
    this.loadUsuarios();
  }

  loadUsuarios(): void {
    const pageable = { page: this.page, size: this.size };

    if (this.selectedRole) {
      this.usuariosService.getUsuariosByRole(this.selectedRole, pageable).subscribe(
        (data) => {
          this.handleUsuariosData(data);
        }
      );
    } else {
      this.usuariosService.getAllUsuarios(pageable).subscribe(
        (data) => {
          this.handleUsuariosData(data);
        },
        (error) => {
          console.error('Error:', error);
          this.handleLoadUsuariosError();
        }
      );
    }
  }

  handleUsuariosData(data: any): void {
    if (data && data.content) {
      console.log('Data received:', data);
      this.usuarios = data.content;
      this.totalElements = data.totalElements;
      console.log('Usuarios:', this.usuarios);
      this.filteredUsuarios = [...this.usuarios];
      this.mensaje = '';
    } else {
      console.error('Invalid data received:', data);
      this.handleLoadUsuariosError();
    }
  }

  handleLoadUsuariosError(): void {
    this.usuarios = [];
    this.filteredUsuarios = [];
    this.mensaje = 'No se encontraron usuarios con ese rol.';
  }

  filterByRole(): void {
    this.page = 0;
    this.loadUsuarios();
  }

  onPageChange(event: PageEvent): void {
    this.page = event.pageIndex;
    this.size = event.pageSize;
    this.loadUsuarios();
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