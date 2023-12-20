import { Component } from '@angular/core';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-area-farmaceutica',
  templateUrl: './area-farmaceutica.component.html',
  styleUrls: ['./area-farmaceutica.component.css']
})
export class AreaFarmaceuticaComponent {

  isAdmin = false;
  isPharma = false;

  constructor(private tokenService: TokenService) { }

  ngOnInit() {   
   this.isAdmin = this.tokenService.isAdmin();
   this.isPharma = this.tokenService.isPharma();
  }

}
