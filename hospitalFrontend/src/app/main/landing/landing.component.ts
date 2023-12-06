import { Component, OnInit } from '@angular/core';
import { TokenService } from '../../services/token.service';
import { faHospital } from '@fortawesome/free-solid-svg-icons';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { RegistroComponent } from 'src/app/seguridad/auth/registro/registro.component';


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
    private router: Router,
    private dialog: MatDialog) { }

  ngOnInit() {
    this.nombreUsuario = this.tokenService.getUserName();
    this.isLogged = this.tokenService.isLogged();
    this.redirect();

    
  }

  openModal() { 
    const dialogRef = this.dialog.open(RegistroComponent, {      
    });  

    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
    });
   
  }

  redirect(): boolean {
    if (this.tokenService.isLogged()) {
      this.router.navigate(['/index']);      
    }
    return false;
  }

}

