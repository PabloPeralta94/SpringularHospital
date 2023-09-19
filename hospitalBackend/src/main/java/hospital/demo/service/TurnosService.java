package hospital.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        this.usuarioRepository = usuarioRepository;
    }
    
    public List<Turno> getAllTurnos() {
        return turnoRepository.getAllTurnos();
    }

    public List<Turno> getTurnosByNombreUsuario(String nombreUsuario) {
        return turnoRepository.getTurnosByNombreUsuario(nombreUsuario);
    }

    public Optional<Turno> getTurnosById(Long turnoId) {
        return turnoRepository.findById(turnoId);
    }

    public Turno createTurno(Turno turno, Usuario usuario) {
    	turno.setUser(usuario);
        return turnoRepository.save(turno);
    }

    public Turno updateTurno(Turno turno) {
        return turnoRepository.save(turno);
    }

    public void deleteTurno(Long turnoId) {
        turnoRepository.deleteById(turnoId);
    }

    public List<Turno> getTurnosByUser(String user) {
        Pageable pageable = null;
        return turnoRepository.findTurnosByUser_NombreUsuario(user, null);
    }

    public List<Turno> getTurnosByTitle(String title) {
        return turnoRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Turno> getTurnosByUserAndTitle(String user, String title) {
        return turnoRepository.findByUser_NombreUsuarioAndTitleContainingIgnoreCase(user, title);
    }

    public Page<Turno> getPaginatedTurnos(Pageable pageable) {
        return turnoRepository.findAll(pageable);
    }

    public Page<Turno> getPaginatedTurnosByUser(String user, Pageable pageable) {
        return (Page<Turno>) turnoRepository.findTurnosByUser_NombreUsuario(user, pageable);
    }

    @Transactional
    public Turno createTurnoForUsuario(String nombreUsuario, String turnoConsultorio, String turnoText) {
        Usuario usuario = usuarioRepository.findByNombreUsuario(nombreUsuario)
                .orElseThrow(() -> new IllegalArgumentException("Usuario with nombreUsuario " + nombreUsuario + " not found."));

        Turno turno = new Turno(turnoConsultorio, turnoText, usuario);

        return turnoRepository.save(turno);
    }
}


