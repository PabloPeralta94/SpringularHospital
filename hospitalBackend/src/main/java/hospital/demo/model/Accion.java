package hospital.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Accion implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accionId;	
	
	private String suceso;

	public Accion() {
		super();
	}

	public Accion(int accionId, String suceso) {
		super();
		this.accionId = accionId;
		this.suceso = suceso;
	}

	public int getAccionId() {
		return accionId;
	}

	public void setAccionId(int accionId) {
		this.accionId = accionId;
	}

	public String getSuceso() {
		return suceso;
	}

	public void setSuceso(String suceso) {
		this.suceso = suceso;
	}
	
	
	

}
