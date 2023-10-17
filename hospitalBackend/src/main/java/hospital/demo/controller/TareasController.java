package hospital.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hospital.demo.dto.receta.RecetaRequest;
import hospital.demo.dto.receta.RecetaResponse;
import hospital.demo.dto.tarea.TareaRequest;
import hospital.demo.dto.tarea.TareaResponse;
import hospital.demo.model.Medicamento;
import hospital.demo.model.Receta;
import hospital.demo.model.Tarea;
import hospital.demo.security.entity.Usuario;
import hospital.demo.security.service.UsuarioService;
import hospital.demo.service.TareaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/tareas")
public class TareasController {

    private final TareaService tareaService;
    private final UsuarioService usuarioService;
    
    private static final Logger logger = LoggerFactory.getLogger(TareasController.class);

    @Autowired
    public TareasController(TareaService tareaService, UsuarioService usuarioService) {
        this.tareaService = tareaService;
        this.usuarioService = usuarioService;
    }
    
 // Get all recetas
    @GetMapping
    public ResponseEntity<List<TareaResponse>> getAllTareas() {
        List<Tarea> tareas = tareaService.getAllTareas();
        List<TareaResponse> tareaResponses = new ArrayList<>();

        for (Tarea tarea : tareas) {
            TareaResponse tareaResponse = tareaService.convertToResponse(tarea);
            tareaResponses.add(tareaResponse);
        }

        return new ResponseEntity<>(tareaResponses, HttpStatus.OK);
    }
    
    @PostMapping("/byUser")
    public ResponseEntity<TareaResponse> createTareaForUsuario(@Valid @RequestBody TareaRequest tarea,
                                                               Authentication authentication) {
        String nombreUsuario = authentication.getName();
        logger.info("Received a request to create a receta for user: {}", nombreUsuario);

        Optional<Usuario> existingUsuario = usuarioService.getByNombreUsuario(nombreUsuario);
        if (!existingUsuario.isPresent()) {
            logger.error("User not found: {}", nombreUsuario);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
     

        Tarea createdTarea = tareaService.createTarea(tarea, existingUsuario.get());
        logger.info("Receta created successfully");

        TareaResponse respuesta = tareaService.convertToResponse(createdTarea);
        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }
    
    @PutMapping("/{tareaId}")
    public ResponseEntity<TareaResponse> updateTarea(
            @PathVariable Integer tareaId,
            @Valid @RequestBody TareaRequest tareaRequest) {
        Optional<Tarea> existingTarea = tareaService.getTareaById(tareaId);
        if (!existingTarea.isPresent()) {
            logger.error("Receta not found with ID: {}",tareaId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Tarea tareaToUpdate = existingTarea.get();
        tareaToUpdate = tareaService.updateTarea(tareaToUpdate, tareaRequest);

        TareaResponse respuesta = tareaService.convertToResponse(tareaToUpdate);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
    
    @DeleteMapping("/{tareaId}")
    public ResponseEntity<Void> deleteReceta(@PathVariable Integer tareaId) {
        Optional<Tarea> existingTarea = tareaService.getTareaById(tareaId);

        if (!existingTarea.isPresent()) {
            logger.error("Receta not found with ID: {}", tareaId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        tareaService.deleteTarea(tareaId);

        logger.info("Receta deleted successfully with ID: {}", tareaId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    

}




