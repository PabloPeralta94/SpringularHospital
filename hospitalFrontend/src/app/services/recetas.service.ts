import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { Receta } from '../interfaces/receta';

@Injectable({
  providedIn: 'root'
})
export class RecetasService {
  recetasURL = environment.recetasUrl;

  constructor(private http: HttpClient) { }

  public getRecetas(): Observable<Receta[]> {
    return this.http.get<Receta[]>(`${this.recetasURL}`);
  }

  public createReceta(receta: Receta): Observable<Receta> { 
    return this.http.post<Receta>(`${this.recetasURL}/crear`, receta); 
  }

  public updateReceta(receta: Receta): Observable<Receta> { 
    return this.http.put<Receta>(`${this.recetasURL}/${receta.recetaId}`, receta); 
  }

  public deleteReceta(recetaId: number): Observable<void> { 
    return this.http.delete<void>(`${this.recetasURL}/${recetaId}`);
  }
}