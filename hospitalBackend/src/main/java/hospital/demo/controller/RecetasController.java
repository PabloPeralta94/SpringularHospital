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
import org.springframework.transaction.annotation.Transactional;
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
import hospital.demo.model.Medicamento;
import hospital.demo.model.Receta;
import hospital.demo.security.entity.Usuario;
import hospital.demo.security.service.UsuarioService;
import hospital.demo.service.MedicamentoService;
import hospital.demo.service.RecetaService;



@RestController
@Transactional
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/receta")
public class RecetasController {
    private final UsuarioService usuarioService;
    private final MedicamentoService medicamentoService;
    private final RecetaService recetaService;

    private static final Logger logger = LoggerFactory.getLogger(RecetasController.class);

    @Autowired
    public RecetasController(UsuarioService usuarioService, MedicamentoService medicamentoService, RecetaService recetaService) {
        this.recetaService = recetaService;
        this.medicamentoService = medicamentoService;
        this.usuarioService = usuarioService;
    }
   
    @GetMapping
    public ResponseEntity<List<RecetaResponse>> getAllRecetas() {
        List<Receta> recetas = recetaService.getAllRecetas();
        List<RecetaResponse> recetaResponses = new ArrayList<>();

        for (Receta receta : recetas) {
            RecetaResponse recetaResponse = recetaService.convertToResponse(receta);
            recetaResponses.add(recetaResponse);
        }

        return new ResponseEntity<>(recetaResponses, HttpStatus.OK);
    }
    
    @PostMapping("/byUser")
    public ResponseEntity<RecetaResponse> createRecetaForUsuario(@Valid @RequestBody RecetaRequest receta,
                                                               Authentication authentication) {
        String nombreUsuario = authentication.getName();
        logger.info("Received a request to create a receta for user: {}", nombreUsuario);

        Optional<Usuario> existingUsuario = usuarioService.getByNombreUsuario(nombreUsuario);
        if (!existingUsuario.isPresent()) {
            logger.error("User not found: {}", nombreUsuario);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Optional<Medicamento> existingMedicamento = medicamentoService.getMedicamentoById(receta.getMedicamentoId());
        if (!existingMedicamento.isPresent()) {
            logger.error("Medicamento not found with ID: {}", receta.getMedicamentoId());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Receta createdReceta = recetaService.createReceta(receta, existingUsuario.get(), existingMedicamento.get());
        logger.info("Receta created successfully");

        RecetaResponse respuesta = recetaService.convertToResponse(createdReceta);
        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }
    
    @PutMapping("/{recetaId}")
    public ResponseEntity<RecetaResponse> updateReceta(
            @PathVariable Integer recetaId,
            @Valid @RequestBody RecetaRequest recetaRequest) {
        Optional<Receta> existingReceta = recetaService.getRecetaById(recetaId);
        if (!existingReceta.isPresent()) {
            logger.error("Receta not found with ID: {}", recetaId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Receta recetaToUpdate = existingReceta.get();
        recetaToUpdate = recetaService.updateReceta(recetaToUpdate, recetaRequest);

        RecetaResponse respuesta = recetaService.convertToResponse(recetaToUpdate);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
    
    @DeleteMapping("/{recetaId}")
    public ResponseEntity<Void> deleteReceta(@PathVariable Integer recetaId) {
        Optional<Receta> existingReceta = recetaService.getRecetaById(recetaId);

        if (!existingReceta.isPresent()) {
            logger.error("Receta not found with ID: {}", recetaId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        recetaService.deleteReceta(recetaId);

        logger.info("Receta deleted successfully with ID: {}", recetaId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

