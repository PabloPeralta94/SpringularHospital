package hospital.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hospital.demo.security.entity.Usuario;
import hospital.demo.security.jwt.JwtProvider;
import hospital.demo.security.service.UsuarioService;
import hospital.demo.service.TurnoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/empleados)")
public class UsuariosController {    
    private final UsuarioService usuarioService;
    private final JwtProvider jwtProvider;
    
    @Autowired
    public UsuariosController( UsuarioService usuarioService, JwtProvider jwtProvider) {        
        this.usuarioService = usuarioService;
        this.jwtProvider = jwtProvider;
    }
    
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioService.getAllUsuarios(); // Define this method in UsuarioService
        if (usuarios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Return a 204 status code if no users are found
        }
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
    
    

}
