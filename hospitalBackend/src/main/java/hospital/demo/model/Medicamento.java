package hospital.demo.model;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import hospital.demo.model.Receta;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
public class Medicamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medicamentoId;

    private String nombre;
    @Lob
    private String descripcion;

    private String precio;

    private boolean esVentaLibre;
    
    @OneToMany(mappedBy = "med", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Receta> recetas = new HashSet<>();
    
    
       

	public Medicamento() {
		super();
	}

	public Medicamento(int medicamentoId, String nombre, String descripcion, String precio, boolean esVentaLibre) {
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
	
	public Set<Receta> getRecetas() {
        return recetas;
    }

    public void setRecetas(Set<Receta> recetas) {
        this.recetas = recetas;
    }
	
    
}
    
