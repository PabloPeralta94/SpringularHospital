package hospital.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hospital.demo.dto.turno.TurnoRequest;
import hospital.demo.dto.turno.TurnoResponse;
import hospital.demo.model.Turno;
import hospital.demo.repository.TurnosRepository;
import hospital.demo.security.entity.Usuario;
import hospital.demo.security.repository.UsuarioRepository;

@Service
@Transactional
public class TurnosService {
	private final TurnosRepository turnoRepository;
    private final UsuarioRepository usuarioRepository;
	

    @Autowired
    public TurnosService(TurnosRepository turnoRepository, UsuarioRepository usuarioRepository) {
        this.turnoRepository = turnoRepository;
        this.usuarioRepository = usuarioRepository;    } 
    
    public List<Turno> getAllTurnos() {
		 
		return turnoRepository.findAll();
	}
  
    

    public Optional<Turno> getTurnosById(int turnoId) {
        return turnoRepository.findById(turnoId);
    }

    public Turno createTurno(TurnoRequest turnoRequest, Usuario usuario) {
    	Turno nuevoTurno = new Turno();
    	
    	nuevoTurno.setConsultorio(turnoRequest.getConsultorio());
    	nuevoTurno.setFecha(turnoRequest.getFecha());
    	nuevoTurno.setPaciente(turnoRequest.getPaciente());
    	nuevoTurno.setText(turnoRequest.getText());
    	
    	nuevoTurno.setUser(usuario);
    	turnoRepository.save(nuevoTurno);
    	
        return nuevoTurno;
    }

    public Turno updateTurno(Turno turno) {
        return turnoRepository.save(turno);
    }

    public void deleteTurno(int turnoId) {
        turnoRepository.deleteById(turnoId);
    }
    

    public Page<Turno> getPaginatedTurnos(Pageable pageable) {
        return turnoRepository.findAll(pageable);
    }

    
    @Transactional
    public Turno createTurnoForUsuario(String nombreUsuario, String turnoConsultorio, String turnoText) {
        Usuario usuario = usuarioRepository.findByNombreUsuario(nombreUsuario)
                .orElseThrow(() -> new IllegalArgumentException("Usuario with nombreUsuario " + nombreUsuario + " not found."));

        Turno turno = new Turno(turnoConsultorio, turnoText, usuario); // Associate the user with the Turno
        return turnoRepository.save(turno);
    }
    

	public TurnoResponse convertToResponse(Turno turno) {
		
		TurnoResponse turnoResponse = new TurnoResponse();
		
		turnoResponse.setConsultorio(turno.getConsultorio());
		turnoResponse.setFecha(turno.getFecha());
		turnoResponse.setPaciente(turno.getPaciente());
		turnoResponse.setText(turno.getText());
		turnoResponse.setTurnoId(turno.getTurnoId());
		turnoResponse.setUsuarioId(turno.getUser().getId());	
		
		return turnoResponse;
	}



	
}


