package hospital.demo.dto.usuario;

import java.util.Set;

import hospital.demo.security.entity.Rol;

public class UsuarioResponse {
	protected int id;
	protected String nombre;
	protected String nombreUsuario;
	protected String email;
	protected Set<Rol> roles;
	
	public UsuarioResponse() {
		super();
	}

	public UsuarioResponse(int id, String nombre, String nombreUsuario, String email, Set<Rol> roles) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.roles = roles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UsuarioResponse [id=" + id + ", nombre=" + nombre + ", nombreUsuario=" + nombreUsuario + ", email="
				+ email + ", roles=" + roles + "]";
	} 
	
	
	 
	
	
	

}
