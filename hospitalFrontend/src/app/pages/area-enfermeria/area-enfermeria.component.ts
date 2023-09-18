import { Component } from '@angular/core';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-area-enfermeria',
  templateUrl: './area-enfermeria.component.html',
  styleUrls: ['./area-enfermeria.component.css']
})
export class AreaEnfermeriaComponent {

  isAdmin = false;
  isNurse = false;

  constructor(private tokenService: TokenService) { }

  ngOnInit() {   
   this.isAdmin = this.tokenService.isAdmin();
   this.isNurse = this.tokenService.isNurse();
  }

}
