import { Component, OnInit } from '@angular/core';
import { TokenService } from '../../services/token.service';
import { AuthService } from 'src/app/services/auth.service';
import { Route, Router } from '@angular/router';
import { LoginUsuario } from 'src/app/interfaces/login-usuario';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginUsuario: LoginUsuario;
  nombreUsuario: string;
  password: string;

  errMsj: string;


  constructor(
    private tokenService: TokenService,
    private authService: AuthService,
    private router: Router
  ) { }

  ngOnInit() {
  }

  onLogin(): void {
    this.loginUsuario = new LoginUsuario(this.nombreUsuario, this.password);
    this.authService.login(this.loginUsuario).subscribe(
      data => {
        this.tokenService.setToken(data.token);
        this.router.navigate(['/landing']);
      },
      err => {
        this.errMsj = err.error.message;
      }
    );
  }

}