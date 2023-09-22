import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { environment } from 'src/environments/environment';
import { turno } from '../interfaces/turno';

@Injectable({
  providedIn: 'root'
})
export class TurnosService {postURL = environment.postURL;
  private turnoCreatedSource = new Subject<void>();

  constructor(private http: HttpClient) { }

  public getTurnos(): Observable<turno[]> {
    return this.http.get<turno[]>(`${this.postURL}`);
  }

  public createTurno(turno: turno): Observable<turno> {
    return this.http.post<turno>(`${this.postURL}/byUser`, turno);
  }

  public getUserPosts(nombreUsuario: string): Observable<turno[]> {
    return this.http.get<turno[]>(`${this.postURL}/byUser?nombreUsuario=${nombreUsuario}`);
  }  
  emitPostCreated() {
    this.turnoCreatedSource.next();
  }
  
  turnoCreated$ = this.turnoCreatedSource.asObservable();
}

