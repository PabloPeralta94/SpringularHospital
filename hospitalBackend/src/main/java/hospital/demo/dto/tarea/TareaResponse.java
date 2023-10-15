package hospital.demo.dto.tarea;

import java.time.LocalDate;

public class TareaResponse {
	
	protected Integer tareaId;

    protected String nombre;
    
    protected String descripcion;
    
    protected LocalDate fechaInicio;
    
    protected LocalDate fechaFin;
    
    protected String enfermeraAsignada;
    
    protected String estado;
    
    protected String prioridad;
    
    protected String pacienteAsociado;
    
    protected String ubicacion;
    
    protected String notas;
    
    protected Integer usuarioId;

	public TareaResponse() {
		super();
	}

	public TareaResponse(Integer tareaId, String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFin,
			String enfermeraAsignada, String estado, String prioridad, String pacienteAsociado, String ubicacion,
			String notas, Integer usuarioId) {
		super();
		this.tareaId = tareaId;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.enfermeraAsignada = enfermeraAsignada;
		this.estado = estado;
		this.prioridad = prioridad;
		this.pacienteAsociado = pacienteAsociado;
		this.ubicacion = ubicacion;
		this.notas = notas;
		this.usuarioId = usuarioId;
	}

	public Integer getTareaId() {
		return tareaId;
	}

	public void setTareaId(Integer tareaId) {
		this.tareaId = tareaId;
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

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getEnfermeraAsignada() {
		return enfermeraAsignada;
	}

	public void setEnfermeraAsignada(String enfermeraAsignada) {
		this.enfermeraAsignada = enfermeraAsignada;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}
    
    
    
    

}
