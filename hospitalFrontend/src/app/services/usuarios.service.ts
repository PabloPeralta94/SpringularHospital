import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UsuarioDto } from '../interfaces/usuario-dto';
import { Page } from '../interfaces/page';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {
  private baseUrl = 'http://localhost:8080/api/v1/empleados'; 

  constructor(private http: HttpClient) { }

  getAllUsuarios(page: number, size: number): Observable<Page<UsuarioDto>> {
    const params = new HttpParams()
      .set('page', page.toString())
      .set('size', size.toString());

    return this.http.get<Page<UsuarioDto>>(`${this.baseUrl}`, { params });
  }

}