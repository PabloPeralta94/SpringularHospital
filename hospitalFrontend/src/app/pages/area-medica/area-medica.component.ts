import { Component } from '@angular/core';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-area-medica',
  templateUrl: './area-medica.component.html',
  styleUrls: ['./area-medica.component.css']
})
export class AreaMedicaComponent {

  isAdmin = false;
  isMedic = false;

  consultoriosData = [
    {
      title: 'Consultorio de Medicina General',
      description: 'Este consultorio ofrece atención médica primaria para una amplia variedad de condiciones médicas y realiza exámenes de rutina.',
      turnosLink: '/turnospen',
      solicitarLink: '/solicturno',
      doctor: 'Dr. Juan Perez',
    },
    {
      title: 'Consultorio de Pediatría',
      description: 'Este consultorio se especializa en el cuidado de niños y adolescentes, abordando problemas de salud específicos para estas edades.',
      turnosLink: '/turnospen',
      solicitarLink: '/pacientes/solicturnos',
      doctor: 'Dra. Maria Rodriguez',
    },
    {
      title: 'Consultorio de Ginecología y Obstetricia',
      description: 'Este consultorio brinda atención médica a mujeres, incluyendo exámenes ginecológicos, control prenatal y atención obstétrica.',
      turnosLink: '/turnospen',
      solicitarLink: '/pacientes/solicturnos',
      doctor: 'Dr. Carlos Gonzalez',
    },
    {
      title: 'Consultorio de Dermatología',
      description: 'El consultorio de Dermatología se enfoca en tratar afecciones de la piel, cabello y uñas, como acné, eczema, cáncer de piel y dermatitis.',
      turnosLink: '/turnospen',
      solicitarLink: '/pacientes/solicturnos',
      doctor: 'Dra. Laura Martinez',
    },
    {
      title: 'Consultorio de Oftalmología',
      description: 'El consultorio de Oftalmología proporciona servicios de atención ocular, como exámenes de la vista, diagnóstico y tratamiento de problemas oculares y cirugías oftalmológicas.',
      turnosLink: '/turnospen',
      solicitarLink: '/pacientes/solicturnos',
      doctor: 'Dr. Alberto Lopez',
    },
    {
      title: 'Consultorio de Endocrinología',
      description: 'Este consultorio se especializa en el diagnóstico y tratamiento de trastornos hormonales y metabólicos. Los pacientes que pueden ingresar incluyen aquellos con problemas de tiroides, diabetes u otros desequilibrios hormonales.',
      turnosLink: '/turnospen',
      solicitarLink: '/pacientes/solicturnos',
      doctor: 'Dra. Ana Sanchez',
    },
    {
      title: 'Consultorio de Cardiología',
      description: 'El consultorio de Cardiología se enfoca en el diagnóstico y tratamiento de enfermedades del corazón y del sistema cardiovascular. Atiende a pacientes con afecciones cardíacas.',
      turnosLink: '/turnospen',
      solicitarLink: '/pacientes/solicturnos',
      doctor: 'Dr. Javier Ramirez',
    },
    {
      title: 'Consultorio de Neurología',
      description: 'El consultorio de Neurología se dedica al diagnóstico y tratamiento de trastornos neurológicos, como migrañas, epilepsia, enfermedad de Alzheimer y otros problemas del sistema nervioso.',
      turnosLink: '/turnospen',
      solicitarLink: '/pacientes/solicturnos',
      doctor: 'Dra. Patricia Garcia',
    },
    {
      title: 'Consultorio de Gastroenterología',
      description: 'Este consultorio se especializa en el diagnóstico y tratamiento de trastornos gastrointestinales, como enfermedades del estómago, el intestino y el hígado.',
      turnosLink: '/turnospen',
      solicitarLink: '/pacientes/solicturnos',
      doctor: 'Dr. Eduardo Fernandez',
    },
    // Agregar consultorios de ser necesario 
  ];

  constructor(private tokenService: TokenService) { }

  ngOnInit() {   
   this.isAdmin = this.tokenService.isAdmin();
   this.isMedic = this.tokenService.isMedic();
  }

}
