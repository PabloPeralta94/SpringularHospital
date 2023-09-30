package hospital.demo.dto.turno;

public class TurnoResponse {
	protected Integer turnoId;
	protected String consultorio;

	protected String text;

	protected String paciente;

	protected String fecha;
	protected Integer usuarioId;
	
		
	public TurnoResponse() {
		super();
	}


	public TurnoResponse(Integer turnoId, String consultorio, String text, String paciente, String fecha,
			Integer usuarioId) {
		super();
		this.turnoId = turnoId;
		this.consultorio = consultorio;
		this.text = text;
		this.paciente = paciente;
		this.fecha = fecha;
		this.usuarioId = usuarioId;
	}


	public Integer getTurnoId() {
		return turnoId;
	}


	public void setTurnoId(Integer turnoId) {
		this.turnoId = turnoId;
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


	public Integer getUsuarioId() {
		return usuarioId;
	}


	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	
	
	
}
