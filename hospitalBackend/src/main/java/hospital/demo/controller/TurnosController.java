package hospital.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hospital.demo.dto.turno.TurnoRequest;
import hospital.demo.dto.turno.TurnoResponse;
import hospital.demo.model.Turno;
import hospital.demo.security.entity.Usuario;
import hospital.demo.security.jwt.JwtProvider;
import hospital.demo.security.service.UsuarioService;
import hospital.demo.service.TurnoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/turnos")
public class TurnosController {
    private final TurnoService turnoService;
    private final UsuarioService usuarioService;
    private final JwtProvider jwtProvider;

    @Autowired
    public TurnosController(TurnoService turnoService, UsuarioService usuarioService, JwtProvider jwtProvider) {
        this.turnoService = turnoService;
        this.usuarioService = usuarioService;
        this.jwtProvider = jwtProvider;
    }

    // Get all turnos
    @GetMapping
    public ResponseEntity<List<Turno>> getAllTurnos(HttpServletRequest request) {
        System.out.println("/getAllTurnos: " + request);

        List<Turno> turnos = turnoService.getAllTurnos();
        return new ResponseEntity<>(turnos, HttpStatus.OK);
    }
    
    @GetMapping("/byUser")
    public ResponseEntity<List<Turno>> getTurnoByUser(Authentication authentication) {
        String username = authentication.getName();

        Optional<Usuario> usuario = usuarioService.getByNombreUsuario(username);

        if (usuario.isPresent()) {
            List<Turno> turnos = turnoService.getTurnosByUsuario(usuario.get());
            return new ResponseEntity<>(turnos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Get a turno by ID
    @GetMapping("/{turnoId}")
    public ResponseEntity<Turno> getTurnosById(@PathVariable int turnoId) {
        Optional<Turno> turno = turnoService.getTurnosById(turnoId);
        return turno.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Create a turno for a user
    @PostMapping("/byUser")
    public ResponseEntity<TurnoResponse> createTurnoForUsuario(@Valid @RequestBody TurnoRequest turno,
                                                              Authentication authentication) {
        String nombreUsuario = authentication.getName();

        Optional<Usuario> existingUsuario = usuarioService.getByNombreUsuario(nombreUsuario);

        if (!existingUsuario.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Turno createdTurno = turnoService.createTurno(turno, existingUsuario.get());

        TurnoResponse respuesta = turnoService.convertToResponse(createdTurno);

        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }

    // Update a turno
    @PutMapping("/{turnoId}")
    public ResponseEntity<Turno> updateTurno(@PathVariable int turnoId, @Valid @RequestBody Turno turno) {
        Optional<Turno> existingTurno = turnoService.getTurnosById(turnoId);
        if (existingTurno.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        turno.setTurnoId(turnoId);
        Turno updatedTurno = turnoService.updateTurno(turno);
        return new ResponseEntity<>(updatedTurno, HttpStatus.OK);
    }

    // Delete a turno
    @DeleteMapping("/{turnoId}")
    public ResponseEntity<String> deleteTurno(@PathVariable int turnoId) {
        Optional<Turno> turno = turnoService.getTurnosById(turnoId);
        if (turno.isEmpty()) {
            return new ResponseEntity<>("Turno not found", HttpStatus.NOT_FOUND);
        }

        turnoService.deleteTurno(turnoId);
        return new ResponseEntity<>("Turno deleted successfully", HttpStatus.NO_CONTENT);
    }

    // Get paginated turnos
    @GetMapping("/paginated")
    public ResponseEntity<Page<Turno>> getPaginatedTurnos(Pageable pageable) {
        Page<Turno> turnos = turnoService.getPaginatedTurnos(pageable);
        return new ResponseEntity<>(turnos, HttpStatus.OK);
    }
}


