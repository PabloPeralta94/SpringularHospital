export interface UsuarioDto {
  id: number;
  nombre: string;
  nombreUsuario: string;
  email: string;
  roles: {
    id: number;
    rolNombre: string;
  }[];
}
