package hospital.demo.dto.medicamento;
import javax.persistence.Lob;

public class MedicamentoRequest {
	
    protected String nombre;
    @Lob
    protected String descripcion;
    
    protected Boolean esVentaLibre;

    protected String precio;

	public MedicamentoRequest() {
		super();
	}

	public MedicamentoRequest(String nombre, String descripcion, Boolean esVentaLibre, String precio) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.esVentaLibre = esVentaLibre;
		this.precio = precio;
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

	public Boolean getEsVentaLibre() {
		return esVentaLibre;
	}

	public void setEsVentaLibre(Boolean esVentaLibre) {
		this.esVentaLibre = esVentaLibre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

}
