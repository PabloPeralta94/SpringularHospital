import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Turno } from '../shared/interfaces/turno';


@Injectable({
  providedIn: 'root'
})
export class TurnosService {postURL = environment.postURL;
  private turnoCreatedSource = new Subject<void>();

  constructor(private http: HttpClient) { }

  public getTurnos(): Observable<Turno[]> {
    return this.http.get<Turno[]>(`${this.postURL}`);
  }

  public createTurno(turno: Turno): Observable<Turno> {
    return this.http.post<Turno>(`${this.postURL}/byUser`, turno);
  }

  public getUserTurnos(nombreUsuario: string): Observable<Turno[]> {
    return this.http.get<Turno[]>(`${this.postURL}/byUser?nombreUsuario=${nombreUsuario}`);
  }  

  public getUserSelfTurnos(): Observable<Turno[]> {
    return this.http.get<Turno[]>(`${this.postURL}/byUser`);
  }

  public updateTurno(turnoId: number, turno: Turno): Observable<Turno> {
    return this.http.put<Turno>(`${this.postURL}/${turnoId}`, turno);
  }

  public deleteTurno(turnoId: number): Observable<string> {
    return this.http.delete<string>(`${this.postURL}/${turnoId}`);
  }
  
  emitTurnoCreated() {
    this.turnoCreatedSource.next();
  }
  
  turnoCreated$ = this.turnoCreatedSource.asObservable();
}

