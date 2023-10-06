import { Component, OnInit } from '@angular/core';
import { BoletasService } from 'src/app/services/boletas.service';

@Component({
  selector: 'app-compras',
  templateUrl: './compras.component.html',
  styleUrls: ['./compras.component.css']
})
export class ComprasComponent implements OnInit {

  constructor(private boletasService: BoletasService) { }

  ngOnInit() {
    // You can call one of these functions when the component initializes
    // Example: this.getAllBoletas();
  }

  // Function to create a new Boleta
  createBoleta(boletaData: any): void {
    this.boletasService.createBoleta(boletaData)
      .subscribe(
        (response) => {
          // Handle success, e.g., show a success message or navigate to another page
        },
        (error) => {
          // Handle error, e.g., display an error message
          console.error('Error:', error);
        }
      );
  }

  // Function to get all Boletas
  getAllBoletas(): void {
    this.boletasService.getAllBoletas()
      .subscribe(
        (boletas) => {
          // Handle the list of Boletas returned by the service
        },
        (error) => {
          // Handle error, e.g., display an error message
          console.error('Error:', error);
        }
      );
  }

  // Function to get a specific Boleta by ID
  getBoletaById(boletaId: number): void {
    this.boletasService.getBoletaById(boletaId)
      .subscribe(
        (boleta) => {
          // Handle the specific Boleta returned by the service
        },
        (error) => {
          // Handle error, e.g., display an error message
          console.error('Error:', error);
        }
      );
  }

  // Function to update an existing Boleta
  updateBoleta(boletaId: number, boletaData: any): void {
    this.boletasService.updateBoleta(boletaId, boletaData)
      .subscribe(
        (response) => {
          // Handle success, e.g., show a success message or navigate to another page
        },
        (error) => {
          // Handle error, e.g., display an error message
          console.error('Error:', error);
        }
      );
  }

  // Function to delete a Boleta by ID
  deleteBoleta(boletaId: number): void {
    this.boletasService.deleteBoleta(boletaId)
      .subscribe(
        () => {
          // Handle success, e.g., show a success message or refresh the list
        },
        (error) => {
          // Handle error, e.g., display an error message
          console.error('Error:', error);
        }
      );
  }
}
