package hospital.demo.dto.receta;

public class RecetaRequest {
    protected String consultorio;   
    protected Integer medicamentoId;
    
    
	public RecetaRequest() {
		super();
	}


	public RecetaRequest(String consultorio, Integer medicamentoId) {
		super();
		this.consultorio = consultorio;		
		this.medicamentoId = medicamentoId;
	}


	public String getConsultorio() {
		return consultorio;
	}


	public void setConsultorio(String consultorio) {
		this.consultorio = consultorio;
	}


	public Integer getMedicamentoId() {
		return medicamentoId;
	}


	public void setMedicamentoId(Integer medicamentoId) {
		this.medicamentoId = medicamentoId;
	}


	@Override
	public String toString() {
		return "RecetaRequest [consultorio=" + consultorio + ", medicamentoId=" + medicamentoId + "]";
	}
}
    
    
    
    
	
    
    

	
	

    
