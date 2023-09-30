package hospital.demo.dto.turno;

public class TurnoRequest {
	protected String consultorio;

	protected String text;

	protected String paciente;

	protected String fecha;

	public TurnoRequest() {
		super();
	}
	
	public TurnoRequest(String consultorio, String text, String paciente, String fecha) {
		super();
		this.consultorio = consultorio;
		this.text = text;
		this.paciente = paciente;
		this.fecha = fecha;
	}



	public String getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(String consultorio) {
		this.consultorio = consultorio;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
}
