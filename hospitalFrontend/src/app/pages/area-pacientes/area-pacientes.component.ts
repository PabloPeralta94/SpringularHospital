import { Component } from '@angular/core';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-area-pacientes',
  templateUrl: './area-pacientes.component.html',
  styleUrls: ['./area-pacientes.component.css']
})
export class AreaPacientesComponent {

  isAdmin = false;
  

  constructor(private tokenService: TokenService) { }

  ngOnInit() {   
   this.isAdmin = this.tokenService.isAdmin();
   
  }

}
