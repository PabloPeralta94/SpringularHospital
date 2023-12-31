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
public class TurnoService {
	private final TurnosRepository turnoRepository;
    private final UsuarioRepository usuarioRepository;
	

    @Autowired
    public TurnoService(TurnosRepository turnoRepository, UsuarioRepository usuarioRepository) {
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

	public List<Turno> getTurnosByUsuario(Usuario usuario) {       
        return turnoRepository.findByUser(usuario);
    }



	
}


