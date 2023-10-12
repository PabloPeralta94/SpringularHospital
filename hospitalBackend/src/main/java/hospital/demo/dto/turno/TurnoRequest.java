package hospital.demo.dto.turno;

import java.time.LocalDate;

public class TurnoRequest {
    protected String consultorio;
    protected String text;
    protected String paciente;
    protected LocalDate fecha; 

    public TurnoRequest() {
        super();
    }

    public TurnoRequest(String consultorio, String text, String paciente, LocalDate fecha) { // Update the constructor
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

    public LocalDate getFecha() { 
        return fecha;
    }

    public void setFecha(LocalDate fecha) { 
        this.fecha = fecha;
    }
}
