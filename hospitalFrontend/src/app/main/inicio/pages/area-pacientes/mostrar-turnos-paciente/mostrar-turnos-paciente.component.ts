import { Component, OnInit } from '@angular/core';
import { Turno } from 'src/app/interfaces/turno';
import { TokenService } from 'src/app/services/token.service';
import { TurnosService } from 'src/app/services/turnos.service';

@Component({
  selector: 'app-mostrar-turnos-paciente',
  templateUrl: './mostrar-turnos-paciente.component.html',
  styleUrls: ['./mostrar-turnos-paciente.component.css']
})
export class MostrarTurnosPacienteComponent implements OnInit {
  public turnos: Turno[] = [];
  isAdmin = false;
  constructor(
    private turnoService: TurnosService,
    private tokenService: TokenService
  ) { }

  ngOnInit(): void {
    this.turnoService.getUserSelfTurnos().subscribe((turnos) => {
      this.turnos = turnos; 
    });
  }
}
