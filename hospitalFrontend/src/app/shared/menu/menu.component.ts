import { Component, OnInit } from '@angular/core';
import { TokenService } from 'src/app/services/token.service';
import { faHospital } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  hospitalIcon = faHospital;

  isLogged = false;
  isAdmin = false;

  constructor(private tokenService: TokenService) { }

  ngOnInit() {
   this.isLogged = this.tokenService.isLogged();
   this.isAdmin = this.tokenService.isAdmin();
  }

  goBack() {
    window.history.back();
  }


  onLogOut(): void {
    this.tokenService.logOut();
  }

  get getTokenService(): TokenService {
    return this.tokenService;
  }

}