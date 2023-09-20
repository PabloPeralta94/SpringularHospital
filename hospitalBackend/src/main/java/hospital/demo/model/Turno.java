package hospital.demo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import hospital.demo.security.entity.Usuario;

@Entity
public class Turno implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int turnoId;

    private String consultorio;

    @Lob
    private String text;

    private String paciente;

    private String fecha;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_nombre_usuario", referencedColumnName = "nombreUsuario")
    private Usuario user;

    public Turno() {

    }

    public Turno(String consultorio, String text, String paciente, String fecha, Usuario user) {
        this.consultorio = consultorio;
        this.text = text;
        this.paciente = paciente;
        this.fecha = fecha;
        this.user = user;
    }
    
    public Turno(String consultorio, String text, Usuario user) {
        this.consultorio = consultorio;
        this.text = text;
        this.user = user;
    }

    public int getTurnoId() {
        return turnoId;
    }

    public void setTurnoId(int turnoId) {
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

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}

