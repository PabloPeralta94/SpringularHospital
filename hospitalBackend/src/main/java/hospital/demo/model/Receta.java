package hospital.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Receta  implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer recetaId;
	
	private String paciente;
	
	private String profesional;
	
	 @ManyToOne // 
	    @JoinColumn(name = "medicamentoId") 
	    private Medicamento medicamento;
	
	private Boolean isAprobada;

	public Receta() {
		super();
	}

	public Receta(Integer recetaId, String paciente, String profesional, Medicamento medicamento, Boolean isAprobada) {
		super();
		this.recetaId = recetaId;
		this.paciente = paciente;
		this.profesional = profesional;
		this.medicamento = medicamento;
		this.isAprobada = isAprobada;
	}

	public Integer getRecetaId() {
		return recetaId;
	}

	public void setRecetaId(Integer recetaId) {
		this.recetaId = recetaId;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public String getProfesional() {
		return profesional;
	}

	public void setProfesional(String profesional) {
		this.profesional = profesional;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public Boolean getIsAprobada() {
		return isAprobada;
	}

	public void setIsAprobada(Boolean isAprobada) {
		this.isAprobada = isAprobada;
	}
	
	
	

}
