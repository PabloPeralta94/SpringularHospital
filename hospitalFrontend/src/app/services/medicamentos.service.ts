import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { environment } from 'src/environments/environment';
import { medicamento } from '../interfaces/medicamento';

@Injectable({
  providedIn: 'root'
})
export class MedicamentosService {
  medicamentosURL = environment.medicamentosUrl;

  constructor(private http: HttpClient) { }

  public getMedicamentos(): Observable<medicamento[]> {
    return this.http.get<medicamento[]>(`${this.medicamentosURL}`);
  }

  public createMedicamento(medicamento: medicamento): Observable<medicamento> {
    return this.http.post<medicamento>(`${this.medicamentosURL}/crear`, medicamento);
  }

  public updateMedicamento(medicamento: medicamento): Observable<medicamento> {
    return this.http.put<medicamento>(`${this.medicamentosURL}/${medicamento.medicamentoId}`, medicamento);
  }

  public deleteMedicamento(medicamentoId: number): Observable<void> {
    return this.http.delete<void>(`${this.medicamentosURL}/${medicamentoId}`);
  }
}