package hospital.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hospital.demo.dto.tarea.TareaResponse;
import hospital.demo.dto.usuario.UsuarioResponse;
import hospital.demo.model.Tarea;
import hospital.demo.model.Turno;
import hospital.demo.security.entity.Usuario;
import hospital.demo.security.jwt.JwtProvider;
import hospital.demo.security.service.UsuarioService;
import hospital.demo.service.TurnoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/empleados")
public class UsuariosController {    
    private final UsuarioService usuarioService;
    private final JwtProvider jwtProvider;
    
    @Autowired
    public UsuariosController( UsuarioService usuarioService, JwtProvider jwtProvider) {        
        this.usuarioService = usuarioService;
        this.jwtProvider = jwtProvider;
    }
    
    @GetMapping
    public ResponseEntity<Page<UsuarioResponse>> getAllUsuarios(Pageable pageable) {
        Page<Usuario> usuariosPage = usuarioService.getAllUsuarios(pageable);

        if (usuariosPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        Page<UsuarioResponse> usuarioResponses = usuariosPage.map(usuarioService::convertToResponse);

        return new ResponseEntity<>(usuarioResponses, HttpStatus.OK);
    }
    
    @GetMapping("/by-role")
    public ResponseEntity<Page<UsuarioResponse>> getUsuariosByRole(
            @RequestParam("role") String role,
            Pageable pageable) {
        Page<Usuario> usuariosPage = usuarioService.getUsuariosByRole(role, pageable);

        if (usuariosPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        Page<UsuarioResponse> usuarioResponses = usuariosPage.map(usuarioService::convertToResponse);

        return new ResponseEntity<>(usuarioResponses, HttpStatus.OK);
    }
    
    @DeleteMapping("/{usuarioId}")
    public ResponseEntity<String> deleteUsuario(@PathVariable int usuarioId) {
        Optional<Usuario> usuario = usuarioService.getById(usuarioId);
        if (usuario.isEmpty()) {
            return new ResponseEntity<>("Usuario not found", HttpStatus.NOT_FOUND);
        }

        usuarioService.deleteUsuario(usuarioId);
        return new ResponseEntity<>("Usuario deleted successfully", HttpStatus.NO_CONTENT);
    }


    
    

}
