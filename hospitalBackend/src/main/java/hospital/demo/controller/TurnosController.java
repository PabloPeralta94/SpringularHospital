package hospital.demo.controller;

import java.util.List;
import java.util.Optional;

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

import hospital.demo.model.Turno;
import hospital.demo.security.entity.Usuario;
import hospital.demo.security.jwt.JwtProvider;
import hospital.demo.security.service.UsuarioService;
import hospital.demo.service.TurnosService;



@RestController
@Transactional
@RequestMapping("/api/v1/turnos")
@CrossOrigin(origins = "http://localhost:4200")
public class TurnosController {
    private final TurnosService turnosService ;
    private final UsuarioService usuarioService;
    private final JwtProvider jwtProvider;

    @Autowired
    public TurnosController(TurnosService turnoService, UsuarioService usuarioService, JwtProvider jwtProvider) {
        this.turnosService = turnoService;
        this.usuarioService = usuarioService;
        this.jwtProvider = jwtProvider;
    }
    

    @GetMapping("/{turnoId}")
    public ResponseEntity<Turno> getTurnosById(@PathVariable int turnoId) {
        Optional<Turno> post = turnosService.getTurnosById(turnoId);
        return post.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/byUser")
    public ResponseEntity<Turno> createTurnoForUsuario(@Valid @RequestBody Turno turno,
                                                     Authentication authentication) {
        // Get the authenticated user's nombreUsuario
        String nombreUsuario = authentication.getName();

        Optional<Usuario> existingUsuario = usuarioService.getByNombreUsuario(nombreUsuario);
        if (existingUsuario.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Turno createdTurno = turnosService.createTurno(turno, existingUsuario.get());
        return new ResponseEntity<>(createdTurno, HttpStatus.CREATED);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<Turno> updatePost(@PathVariable int turnoId, @Valid @RequestBody Turno turno) {
        Optional<Turno> existingTurno = turnosService.getTurnosById(turnoId);
        if (existingTurno.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        turno.setTurnoId(turnoId);
        Turno updatedPost = turnosService.updateTurno(turno);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable int turnoId) {
        Optional<Turno> turno = turnosService.getTurnosById(turnoId);
        if (turno.isEmpty()) {
            return new ResponseEntity<>("Post not found", HttpStatus.NOT_FOUND);
        }

        turnosService.deleteTurno(turnoId);
        return new ResponseEntity<>("Post deleted successfully", HttpStatus.NO_CONTENT);
    }

   
 

    @GetMapping("/paginated")
    public ResponseEntity<Page<Turno>> getPaginatedTurnos(Pageable pageable) {
        Page<Turno> turno = turnosService.getPaginatedTurnos(pageable);
        return new ResponseEntity<>(turno, HttpStatus.OK);
    }





}

