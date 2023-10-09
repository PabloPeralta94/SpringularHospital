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

import com.fasterxml.jackson.annotation.JsonIgnore;

import hospital.demo.dto.turno.TurnoResponse;
import hospital.demo.security.entity.Usuario;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Turno implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int turnoId;

    private String consultorio;

    @Lob
    private String text;

    private String paciente;

    @Column(columnDefinition = "DATE") // Define the column as DATE type in the database
    private LocalDate fecha; // Change the type to LocalDate

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_nombre_usuario", referencedColumnName = "nombreUsuario")
    private Usuario user;

    public Turno() {

    }

    public Turno(String consultorio, String text, String paciente, LocalDate fecha, Usuario user) {
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}

