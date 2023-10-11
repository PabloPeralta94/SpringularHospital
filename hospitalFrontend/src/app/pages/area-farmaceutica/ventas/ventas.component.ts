import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { TokenService } from 'src/app/services/token.service';
import { Medicamento } from 'src/app/interfaces/medicamento';
import { MedicamentosService } from 'src/app/services/medicamentos.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-ventas',
  templateUrl: './ventas.component.html',
  styleUrls: ['./ventas.component.css']
})
export class VentasComponent implements OnInit, OnDestroy {
  public medicamentos: Medicamento[] = [];
  isAdmin = false;
  private medicamentoCreatedSubscription: Subscription;

  constructor(
    private medicamentosService: MedicamentosService,
    private tokenService: TokenService
  ) { }

  ngOnInit() {
    this.getMedicamentos();
    this.isAdmin = this.tokenService.isAdmin();
    ;
  }

  ngOnDestroy() {    
  }

  public getMedicamentos(): void {
    this.medicamentosService.getMedicamentos().subscribe(
      (response: Medicamento[]) => {
        this.medicamentos = response.sort((a, b) => b.medicamentoId - a.medicamentoId);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}