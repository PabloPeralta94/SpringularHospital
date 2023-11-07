import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-consultorio',
  templateUrl: './consultorio.component.html',
  styleUrls: ['./consultorio.component.css']
})
export class ConsultorioComponent {
  @Input() title: string;
  @Input() description: string;
  @Input() turnosLink: string;
  @Input() solicitarLink: string;
  @Input() isAdmin: boolean;
  @Input() isMedic: boolean;
  @Input() doctor: string;
}