import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { TokenService } from 'src/app/services/token.service';

import { TurnosService } from 'src/app/services/turnos.service';
import { Turno } from 'src/app/shared/interfaces/turno';



@Component({
  selector: 'app-turnos-pendientes',
  templateUrl: './turnos-pendientes.component.html',
  styleUrls: ['./turnos-pendientes.component.css']
})
export class TurnosPendientesComponent implements OnInit, OnDestroy {
  public turnos: Turno[] = [];
  isAdmin = false;
  private postCreatedSubscription: Subscription;

  constructor(
    private turnoService: TurnosService,
    private tokenService: TokenService
  ) { }

  ngOnInit() {
    this.getTurnos();
    this.isAdmin = this.tokenService.isAdmin();

    this.postCreatedSubscription = this.turnoService.turnoCreated$.subscribe(() => {
      this.getTurnos();
    });
  }

  ngOnDestroy() {
    this.postCreatedSubscription.unsubscribe();
  }

  public getTurnos(): void {
    this.turnoService.getTurnos().subscribe(
      (response: Turno[]) => {
        this.turnos = response.sort((a, b) => b.turnoId! - a.turnoId!);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}