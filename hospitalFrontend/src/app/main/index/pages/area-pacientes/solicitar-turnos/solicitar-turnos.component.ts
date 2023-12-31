import { Component } from '@angular/core';
import { TurnosService } from 'src/app/services/turnos.service';

@Component({
  selector: 'app-solicitar-turnos',
  templateUrl: './solicitar-turnos.component.html',
  styleUrls: ['./solicitar-turnos.component.css']
})
export class SolicitarTurnosComponent {
consultorio: string = "";
paciente: string = "";
body: string = "";





consultorioPreview(event: any) {
  this.consultorio = event.target.value;
}
bodyPreview(event: any) {
  this.body = event.target.value;
}
pacientePreview(event: any) {
  this.paciente = event.target.value;
}
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