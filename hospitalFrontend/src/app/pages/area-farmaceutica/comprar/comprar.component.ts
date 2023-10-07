import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { medicamento } from 'src/app/interfaces/medicamento';
import { MedicamentosService } from 'src/app/services/medicamentos.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-comprar',
  templateUrl: './comprar.component.html',
  styleUrls: ['./comprar.component.css']
})
export class ComprarComponent implements OnInit, OnDestroy {
  public medicamentos: medicamento[] = [];
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
      (response: medicamento[]) => {
        this.medicamentos = response.sort((a, b) => b.medicamentoId - a.medicamentoId);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}
