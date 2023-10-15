package hospital.demo.dto.tarea;

import java.time.LocalDate;

public class TareaRequest {

	    protected String nombre;
	    
	    protected String descripcion;	    
	    
	    protected String enfermeraAsignada;
	    
	    protected String prioridad;
	    
	    protected String pacienteAsociado;
	    
	    protected String ubicacion;
	    
	    protected String notas;

		public TareaRequest() {
			super();
		}

		public TareaRequest(String nombre, String descripcion, String enfermeraAsignada, String prioridad,
				String pacienteAsociado, String ubicacion, String notas) {
			super();
			this.nombre = nombre;
			this.descripcion = descripcion;
			this.enfermeraAsignada = enfermeraAsignada;
			this.prioridad = prioridad;
			this.pacienteAsociado = pacienteAsociado;
			this.ubicacion = ubicacion;
			this.notas = notas;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public String getEnfermeraAsignada() {
			return enfermeraAsignada;
		}

		public void setEnfermeraAsignada(String enfermeraAsignada) {
			this.enfermeraAsignada = enfermeraAsignada;
		}

		public String getPrioridad() {
			return prioridad;
		}

		public void setPrioridad(String prioridad) {
			this.prioridad = prioridad;
		}

		public String getPacienteAsociado() {
			return pacienteAsociado;
		}

		public void setPacienteAsociado(String pacienteAsociado) {
			this.pacienteAsociado = pacienteAsociado;
		}

		public String getUbicacion() {
			return ubicacion;
		}

		public void setUbicacion(String ubicacion) {
			this.ubicacion = ubicacion;
		}

		public String getNotas() {
			return notas;
		}

		public void setNotas(String notas) {
			this.notas = notas;
		}

		@Override
		public String toString() {
			return "TareaRequest [nombre=" + nombre + ", descripcion=" + descripcion + ", enfermeraAsignada="
					+ enfermeraAsignada + ", prioridad=" + prioridad + ", pacienteAsociado=" + pacienteAsociado
					+ ", ubicacion=" + ubicacion + ", notas=" + notas + "]";
		}	
	    
	    
	

}
