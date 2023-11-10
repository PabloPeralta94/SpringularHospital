import { Component } from '@angular/core';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-area-directiva',
  templateUrl: './area-directiva.component.html',
  styleUrls: ['./area-directiva.component.css']
})
export class AreaDirectivaComponent {

  isAdmin = false;
  isDirector = false;

  constructor(private tokenService: TokenService) { }

  ngOnInit() {   
   this.isAdmin = this.tokenService.isAdmin();
   this.isDirector = this.tokenService.isDirector();
  }

}
