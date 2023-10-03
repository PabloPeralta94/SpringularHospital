package hospital.demo.dto.receta;

public class RecetaResponse {
    protected Integer recetaId;
    protected String consultorio;
    protected Integer usuarioId;
    protected Integer medicamentoId;   
    protected Boolean estaAprobado;
    
    
	public RecetaResponse() {
		super();
	}


	public RecetaResponse(Integer recetaId, String consultorio, Integer usuarioId, Integer medicamentoId,
			Boolean estaAprobado) {
		super();
		this.recetaId = recetaId;
		this.consultorio = consultorio;
		this.usuarioId = usuarioId;
		this.medicamentoId = medicamentoId;
		this.estaAprobado = estaAprobado;
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


	public Integer getUsuarioId() {
		return usuarioId;
	}


	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}


	public Integer getMedicamentoId() {
		return medicamentoId;
	}


	public void setMedicamentoId(Integer medicamentoId) {
		this.medicamentoId = medicamentoId;
	}


	public Boolean getEstaAprobado() {
		return estaAprobado;
	}


	public void setEstaAprobado(Boolean estaAprobado) {
		this.estaAprobado = estaAprobado;
	}	
	
	
    
    
    
    
}