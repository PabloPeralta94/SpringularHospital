package hospital.demo.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import hospital.demo.security.entity.Usuario;

@Entity
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tareaId;

    private String nombre;
    
    private String descripcion;
    
    private LocalDate fechaInicio;
    
    private LocalDate fechaFin;
    
    private String enfermeraAsignada;
    
    private String estado;
    
    private String prioridad;
    
    private String pacienteAsociado;
    
    private String ubicacion;
    
    private String notas;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "tarea_nombre_usuario", referencedColumnName = "nombreUsuario")
    private Usuario usuario;

	public Tarea() {
		super();
	}

	public Tarea(Integer tareaId, String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFin,
			String enfermeraAsignada, String estado, String prioridad, String pacienteAsociado, String ubicacion,
			String notas, Usuario usuario) {
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
		this.usuario = usuario;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Tarea [tareaId=" + tareaId + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechaInicio="
				+ fechaInicio + ", fechaFin=" + fechaFin + ", enfermeraAsignada=" + enfermeraAsignada + ", estado="
				+ estado + ", prioridad=" + prioridad + ", pacienteAsociado=" + pacienteAsociado + ", ubicacion="
				+ ubicacion + ", notas=" + notas + ", usuario=" + usuario + "]";
	}

	
	
    

}