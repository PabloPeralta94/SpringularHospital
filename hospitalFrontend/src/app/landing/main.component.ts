import { Component, OnInit } from '@angular/core';
import { TokenService } from '../services/token.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  nombreUsuario: string;

  constructor(private tokenService: TokenService) { }

  ngOnInit() {
    this.nombreUsuario = this.tokenService.getUserName();
  }

}

