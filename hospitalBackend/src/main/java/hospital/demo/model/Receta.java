package hospital.demo.model;

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
public class Receta {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer recetaId;
	
	private String consultorio;
	
	 @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	    @JoinColumn(name = "user_nombre_usuario", referencedColumnName = "nombreUsuario")
	    private Usuario user;
	 
	 
	 @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	    @JoinColumn(name = "med_medicamento_id", referencedColumnName = "medicamentoId")
	 private Medicamento med;


	public Receta() {
		super();
	}


	public Receta(Integer recetaId, String consultorio, Usuario user, Medicamento med) {
		super();
		this.recetaId = recetaId;
		this.consultorio = consultorio;
		this.user = user;
		this.med = med;
	}


	public Integer getRecetaId() {
		return recetaId;
	}


	public void setRecetaId(Integer recetaId) {
		this.recetaId = recetaId;
	}


	public String getConsultorio() {
		return consultorio;
	}


	public void setConsultorio(String consultorio) {
		this.consultorio = consultorio;
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
	 


}
