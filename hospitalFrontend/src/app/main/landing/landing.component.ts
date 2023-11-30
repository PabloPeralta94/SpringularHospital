import { Component, OnInit } from '@angular/core';
import { TokenService } from '../../services/token.service';
import { faHospital } from '@fortawesome/free-solid-svg-icons';
import { Router } from '@angular/router';

@Component({
  selector: 'app-main',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent implements OnInit {
  hospitalIcon = faHospital;

  nombreUsuario: string;
  isLogged: boolean = false;

  constructor(private tokenService: TokenService,
    private router: Router) { }

  ngOnInit() {
    this.nombreUsuario = this.tokenService.getUserName();
    this.isLogged = this.tokenService.isLogged();
    this.redirect();

    
  }

  openModal() {
    
   
  }

  redirect(): boolean {
    if (this.tokenService.isLogged()) {
      this.router.navigate(['/index']);      
    }
    return false;
  }

}

