import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UsuarioDto } from '../interfaces/usuario-dto';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {
  private baseUrl = 'http://localhost:8080/api/v1/empleados'; 

  constructor(private http: HttpClient) { }

  getAllUsuarios(): Observable<UsuarioDto[]> {
    return this.http.get<UsuarioDto[]>(`${this.baseUrl}`);
  }


}