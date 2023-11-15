package hospital.demo.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hospital.demo.dto.tarea.TareaResponse;
import hospital.demo.dto.usuario.UsuarioResponse;
import hospital.demo.security.entity.Usuario;
import hospital.demo.security.enums.RolNombre;
import hospital.demo.security.repository.UsuarioRepository;


import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;
    
    public Page<Usuario> getAllUsuarios(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public boolean existsByNombreUsuario(String nombreUsuario){
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existsByEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }

    public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public Optional<Usuario> getById(int id) {
        return usuarioRepository.findById(id);
    }

	public List<Usuario> getAllUsuarios() {
		
		return usuarioRepository.findAll();
	}
	
	public Page<Usuario> getUsuariosByRole(String role, Pageable pageable) {
        RolNombre rolNombreEnum = RolNombre.valueOf(role);
        return usuarioRepository.findByRoles_RolNombre(rolNombreEnum, pageable);
    }

	public UsuarioResponse convertToResponse(Usuario usuario) {
		
		UsuarioResponse usuarioResponse = new UsuarioResponse();
		
		usuarioResponse.setId(usuario.getId());
		usuarioResponse.setNombre(usuario.getNombre());
		usuarioResponse.setNombreUsuario(usuario.getNombreUsuario());
		usuarioResponse.setEmail(usuario.getEmail());
		usuarioResponse.setRoles(usuario.getRoles());
		
		return usuarioResponse;
		
		
	}

   
}

