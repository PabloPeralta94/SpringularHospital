import { Component } from '@angular/core';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-area-administrativa',
  templateUrl: './area-administrativa.component.html',
  styleUrls: ['./area-administrativa.component.css']
})
export class AreaAdministrativaComponent {
  
  isAdmin = false;

  constructor(private tokenService: TokenService) { }

  ngOnInit() {   
   this.isAdmin = this.tokenService.isAdmin();
  }

}
