import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Page } from '../shared/interfaces/page';
import { UsuarioDto } from '../shared/interfaces/usuario-dto';


@Injectable({
  providedIn: 'root'
})
export class UsuariosService {
  private baseUrl = 'http://localhost:8080/api/v1/empleados'; 

  constructor(private http: HttpClient) { }

  getAllUsuarios(pageable: any): Observable<Page<UsuarioDto>> {
    const params = new HttpParams()
      .set('page', pageable.page.toString())
      .set('size', pageable.size.toString());

    return this.http.get<Page<UsuarioDto>>(`${this.baseUrl}`, { params });
  }

  getUsuariosByRole(role: string, pageable: any): Observable<Page<UsuarioDto>> {
    const params = new HttpParams()
      .set('role', role)
      .set('page', pageable.page.toString())
      .set('size', pageable.size.toString());

    return this.http.get<Page<UsuarioDto>>(`${this.baseUrl}/by-role`, { params });
  }
}
