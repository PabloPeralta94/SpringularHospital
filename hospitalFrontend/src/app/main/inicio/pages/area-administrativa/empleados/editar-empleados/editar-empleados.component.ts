import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-editar-empleados',
  templateUrl: './editar-empleados.component.html',
  styleUrls: ['./editar-empleados.component.css']
})
export class EditarEmpleadosComponent {

  // Define the form group
  form: FormGroup;

  constructor(private fb: FormBuilder) {
    // Create the form with FormBuilder
    this.form = this.fb.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      message: ['', Validators.required]
    });
  }

  // Function to submit the form
  onSubmit() {
    if (this.form.valid) {
      // Form data is valid, you can handle it here
      console.log(this.form.value);
    } else {
      // Form data is invalid, show error messages
    }
  }

}
