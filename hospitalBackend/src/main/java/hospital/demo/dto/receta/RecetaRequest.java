package hospital.demo.dto.receta;

public class RecetaRequest {
    protected String consultorio;
    protected Integer usuarioId;
    protected Integer medicamentoId;
    
    
	public RecetaRequest() {
		super();
	}


	public RecetaRequest(String consultorio, Integer usuarioId, Integer medicamentoId) {
		super();
		this.consultorio = consultorio;
		this.usuarioId = usuarioId;
		this.medicamentoId = medicamentoId;
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
	
	

    
}