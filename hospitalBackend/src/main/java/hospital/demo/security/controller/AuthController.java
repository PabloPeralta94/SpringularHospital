package hospital.demo.security.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import hospital.demo.security.dto.JwtDto;
import hospital.demo.security.dto.LoginUsuario;
import hospital.demo.security.dto.NuevoUsuario;
import hospital.demo.security.entity.Rol;
import hospital.demo.security.entity.Usuario;
import hospital.demo.security.enums.RolNombre;
import hospital.demo.security.jwt.JwtProvider;
import hospital.demo.security.service.RolService;
import hospital.demo.security.service.UsuarioService;
import io.swagger.annotations.ApiOperation;
import hospital.demo.security.dto.Mensaje;
import java.util.Arrays;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    
    @ApiOperation("Crea un nuevo usuario")
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Mensaje("Campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
        }

        if (usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario())) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (usuarioService.existsByEmail(nuevoUsuario.getEmail())) {
            return new ResponseEntity(new Mensaje("Ese email ya existe"), HttpStatus.BAD_REQUEST);
        }

        Usuario usuario = new Usuario(
                nuevoUsuario.getNombre(),
                nuevoUsuario.getNombreUsuario(),
                nuevoUsuario.getEmail(),
                passwordEncoder.encode(nuevoUsuario.getPassword())
        );

        Set<Rol> roles = new HashSet<>();

        
        for (String role : nuevoUsuario.getRoles()) {
            RolNombre rolNombre = RolNombre.valueOf("ROLE_" + role.toUpperCase()); 
            if (Arrays.stream(RolNombre.values()).anyMatch(r -> r.equals(rolNombre))) {
                roles.add(rolService.getByRolNombre(rolNombre).get());
            }
        }        
        if (roles.isEmpty()) {
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        }

        usuario.setRoles(roles);
        usuarioService.save(usuario);

        return new ResponseEntity(new Mensaje("Usuario guardado"), HttpStatus.CREATED);
    }

    
    @ApiOperation("Obtiene un bearer token logueando un usuario")
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login( @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        JwtDto jwtDto = new JwtDto(jwt);
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtDto> refresh(@RequestBody JwtDto jwtDto) throws ParseException {
        String token = jwtProvider.refreshToken(jwtDto);
        JwtDto jwt = new JwtDto(token);
        return new ResponseEntity(jwt, HttpStatus.OK);
    }
}