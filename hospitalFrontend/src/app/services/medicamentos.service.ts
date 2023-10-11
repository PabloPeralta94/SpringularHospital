import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Medicamento } from '../interfaces/medicamento';

@Injectable({
  providedIn: 'root'
})
export class MedicamentosService {
  medicamentosURL = environment.medicamentosUrl;

  constructor(private http: HttpClient) { }

  public getMedicamentos(): Observable<Medicamento[]> {
    return this.http.get<Medicamento[]>(`${this.medicamentosURL}`);
  }

  public getMedicamentosById(medicamentoId: number): Observable<Medicamento> {
    return this.http.get<Medicamento>(`${this.medicamentosURL}/${medicamentoId}`);
  }

  public createMedicamento(medicamento: Medicamento): Observable<Medicamento> {
    return this.http.post<Medicamento>(`${this.medicamentosURL}/crear`, medicamento);
  }

  public updateMedicamento(medicamento: Medicamento): Observable<Medicamento> {
    return this.http.put<Medicamento>(`${this.medicamentosURL}/${medicamento.medicamentoId}`, medicamento);
  }

  public deleteMedicamento(medicamentoId: number): Observable<void> {
    return this.http.delete<void>(`${this.medicamentosURL}/${medicamentoId}`);
  }
}