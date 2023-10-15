import { Component } from '@angular/core';
import { TurnosService } from 'src/app/services/turnos.service';
import { Turno } from 'src/app/interfaces/turno';

@Component({
  selector: 'app-solicitar-turnos',
  templateUrl: './solicitar-turnos.component.html',
  styleUrls: ['./solicitar-turnos.component.css']
})
export class SolicitarTurnosComponent {
  turnoConsultorio: string;
  turnoBody: string;
  turnoPaciente: string;
  turnoFecha: Date | null;

  constructor(private turnoService: TurnosService) { }

  onSubmit() {
    const turno = {
      consultorio: this.turnoConsultorio,
      text: this.turnoBody,
      paciente: this.turnoPaciente,
      fecha: this.turnoFecha,
    };

    this.turnoService.createTurno(turno).subscribe(
      (createdTurno) => {
        console.log('Created Turno:', createdTurno);
        this.turnoConsultorio = '';
        this.turnoBody = '';
        this.turnoPaciente = '';
        this.turnoFecha = null;
        this.turnoService.emitTurnoCreated();
      },
      (error) => {
        console.error('Error creating turno:', error);
      }
    );
  }
}