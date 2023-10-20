import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Tarea } from 'src/app/interfaces/tarea';
import { TareasService } from 'src/app/services/tareas.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-ver-tareas',
  templateUrl: './ver-tareas.component.html',
  styleUrls: ['./ver-tareas.component.css']
})
export class VerTareasComponent implements OnInit, OnDestroy {
  public tareas: Tarea[] = [];
  isAdmin = false;

  constructor(
    private tareaService: TareasService,
    private tokenService: TokenService
  ) { }

  ngOnInit() {
    this.getTareas();
    this.isAdmin = this.tokenService.isAdmin();        
  }

  ngOnDestroy() {   
  }

  public getTareas(): void {
    this.tareaService.getTareas().subscribe(
      (response: Tarea[]) => {
        this.tareas = response.sort((a, b) => b.tareaId! - a.tareaId!);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}