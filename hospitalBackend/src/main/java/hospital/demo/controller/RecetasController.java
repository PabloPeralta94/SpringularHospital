package hospital.demo.controller;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hospital.demo.dto.receta.RecetaRequest;
import hospital.demo.dto.receta.RecetaResponse;
import hospital.demo.model.Medicamento;
import hospital.demo.model.Receta;
import hospital.demo.security.entity.Usuario;
import hospital.demo.security.service.UsuarioService;
import hospital.demo.service.MedicamentosService;
import hospital.demo.service.RecetasService;



@RestController
@Transactional
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/receta")
public class RecetasController {
	private final UsuarioService usuarioService;
	private final MedicamentosService medicamentosService;
	private final RecetasService recetasService;
	
	private static final Logger logger = LoggerFactory.getLogger(RecetasController.class);

	
	@Autowired
	public RecetasController(UsuarioService usuarioService, MedicamentosService medicamentosService, RecetasService recetasService) {
		this.recetasService = recetasService;
		this.medicamentosService = medicamentosService;
		this.usuarioService = usuarioService;
		
	}
	

    @GetMapping
    public ResponseEntity<List<Receta>> getAllRecetas() {
        List<Receta> recetas = recetasService.getAllRecetas();
        return new ResponseEntity<>(recetas, HttpStatus.OK);
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

        Optional<Medicamento> existingMedicamento = medicamentosService.getMedicamentoById(receta.getMedicamentoId());
        if (!existingMedicamento.isPresent()) {
            logger.error("Medicamento not found with ID: {}", receta.getMedicamentoId());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } 

        Receta CreatedReceta = recetasService.createReceta(receta, existingUsuario.get(), existingMedicamento.get());
        logger.info("Receta created successfully");

        RecetaResponse respuesta = recetasService.convertToResponse(CreatedReceta);   
        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }


	

}
