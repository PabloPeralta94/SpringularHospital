import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Tarea } from '../interfaces/tarea';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TareasService {
  tareasURL = environment.tareasUrl;

  constructor(private http: HttpClient) {}

    public getTareas(): Observable<Tarea[]> {
      return this.http.get<Tarea[]>(`${this.tareasURL}`);
    }
  
    public createTarea(tarea: Tarea): Observable<Tarea> { 
      return this.http.post<Tarea>(`${this.tareasURL}/byUser`, tarea); 
    }
  
    public updateTarea(tarea: Tarea): Observable<Tarea> { 
      return this.http.put<Tarea>(`${this.tareasURL}/${tarea.tareaId}`, tarea); 
    }
  
    public deleteTarea(tareaId: number): Observable<void> { 
      return this.http.delete<void>(`${this.tareasURL}/${tareaId}`);
    }
   }

  
