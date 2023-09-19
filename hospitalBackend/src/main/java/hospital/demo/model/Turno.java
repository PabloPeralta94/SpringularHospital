package hospital.demo.model;

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
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long turnoId;

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

    public Turno(String title, String text, String paciente, String fecha, Usuario user) {
        this.consultorio = title;
        this.text = text;
        this.paciente = paciente;
        this.fecha = fecha;
        this.user = user;
    }



    public Turno(String turnoConsultorio, String turnoText, Usuario usuario) {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
        return turnoId;
    }

    public void setId(Long id) {
        this.turnoId = id;
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

    public void setVideoUrl(String fecha) {
        this.fecha = fecha;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}
