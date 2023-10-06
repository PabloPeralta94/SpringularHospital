package hospital.demo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import hospital.demo.security.entity.Usuario;

@Entity
public class Boleta  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boletaId;	
	
	private int valor;
	
	private Boolean estaPagada;
	
	 @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	    @JoinColumn(name = "user_nombre_usuario", referencedColumnName = "nombreUsuario")
	    private Usuario user;
	 
	 
	 @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	    @JoinColumn(name = "med_medicamento_id", referencedColumnName = "medicamentoId")
	 private Medicamento med;
	 
	 @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	    @JoinColumn(name = "med_medicamento_id", referencedColumnName = "medicamentoId")
	 private Receta receta;

	public Boleta() {
		super();
	}

	public Boleta(int boletaId, int valor, Boolean estaPagada, Usuario user, Medicamento med, Receta receta) {
		super();
		this.boletaId = boletaId;
		this.valor = valor;
		this.estaPagada = estaPagada;
		this.user = user;
		this.med = med;
		this.receta = receta;
	}

	public int getBoletaId() {
		return boletaId;
	}

	public void setBoletaId(int boletaId) {
		this.boletaId = boletaId;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Boolean getEstaPagada() {
		return estaPagada;
	}

	public void setEstaPagada(Boolean estaPagada) {
		this.estaPagada = estaPagada;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public Medicamento getMed() {
		return med;
	}

	public void setMed(Medicamento med) {
		this.med = med;
	}

	public Receta getReceta() {
		return receta;
	}

	public void setReceta(Receta receta) {
		this.receta = receta;
	}
	 
	 

}
