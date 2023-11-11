package hospital.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hospital.demo.dto.tarea.TareaResponse;
import hospital.demo.dto.usuario.UsuarioResponse;
import hospital.demo.model.Tarea;
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
    public ResponseEntity<List<UsuarioResponse>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioService.getAllUsuarios();
        if (usuarios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<UsuarioResponse> usuarioResponses = new ArrayList<>();
        
        for (Usuario usuario : usuarios) {
            UsuarioResponse usuarioResponse = usuarioService.convertToResponse(usuario);
            usuarioResponses.add(usuarioResponse);
        }
        return new ResponseEntity<>(usuarioResponses, HttpStatus.OK);
    }

    
    

}
