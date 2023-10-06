import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BoletasService {

  
private baseUrl = '/api/boletas'; // Replace with the actual API endpoint

constructor(private http: HttpClient) { }

// Create a new Boleta
createBoleta(boleta: any): Observable<any> {
  return this.http.post(`${this.baseUrl}/`, boleta);
}

// Read all Boletas
getAllBoletas(): Observable<any[]> {
  return this.http.get<any[]>(`${this.baseUrl}/`);
}

getBoletaById(boletaId: number): Observable<any> {
  return this.http.get<any>(`${this.baseUrl}/${boletaId}`);
}

updateBoleta(boletaId: number, boleta: any): Observable<any> {
  return this.http.put(`${this.baseUrl}/${boletaId}`, boleta);
}

deleteBoleta(boletaId: number): Observable<any> {
  return this.http.delete(`${this.baseUrl}/${boletaId}`);
}
}
