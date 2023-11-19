import { Component } from '@angular/core';

@Component({
  selector: 'app-correo',
  templateUrl: './correo.component.html',
  styleUrls: ['./correo.component.css']
})
export class CorreoComponent {
  user: string = "fernando";
  title: string = "consulta";
  contenido: string = "necesito algo? creo";

}
