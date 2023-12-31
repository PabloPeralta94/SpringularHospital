package hospital.demo.dto.medicamento;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class MedicamentoResponse {
	
	protected int medicamentoId;

    protected String nombre;
    @Lob
    protected String descripcion;

    protected String precio;

    protected boolean esVentaLibre;    
   

	public MedicamentoResponse() {
		super();
	}

	public MedicamentoResponse(int medicamentoId, String nombre, String descripcion, String precio,
			boolean esVentaLibre) {
		super();
		this.medicamentoId = medicamentoId;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.esVentaLibre = esVentaLibre;		
	}

	public int getMedicamentoId() {
		return medicamentoId;
	}

	public void setMedicamentoId(int medicamentoId) {
		this.medicamentoId = medicamentoId;
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

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public boolean isEsVentaLibre() {
		return esVentaLibre;
	}

	public void setEsVentaLibre(boolean esVentaLibre) {
		this.esVentaLibre = esVentaLibre;
	}
	

}
