package hospital.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
import hospital.demo.model.Medicamento;
import hospital.demo.model.Receta;
import hospital.demo.repository.MedicamentosRepository;
import hospital.demo.repository.RecetasRepository;
import hospital.demo.security.entity.Usuario;
import hospital.demo.security.repository.UsuarioRepository;
import hospital.demo.security.service.UsuarioService;
import hospital.demo.service.MedicamentosService;
import hospital.demo.service.RecetasService;



@RestController
@Transactional
@RequestMapping("/recetas")
@CrossOrigin(origins = "http://localhost:4200")
public class RecetasController {
	private final UsuarioService usuarioService;
	private final MedicamentosService medicamentosService;
	private final RecetasService recetasService;
	
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
	
	/* @PostMapping("/byUser")
    public ResponseEntity<Receta> createRecetaForUsuario(@Valid @RequestBody Receta receta,
                                                     Authentication authentication) {
        // Get the authenticated user's nombreUsuario
        String nombreUsuario = authentication.getName();

        Optional<Usuario> existingUsuario = usuarioService.getByNombreUsuario(nombreUsuario);
        if (existingUsuario.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Receta createdReceta = recetasService.createReceta(receta, existingUsuario.get());
        return new ResponseEntity<>(createdReceta, HttpStatus.CREATED);
    } */
	
	@PostMapping("/byUser")
	public ResponseEntity<Receta> createRecetaForUsuario(@Valid @RequestBody Receta receta,
	                                                   Authentication authentication) {
		
	    System.out.println("recetas/byUser: " + receta.toString());
	
	    String nombreUsuario = authentication.getName();

	    Optional<Usuario> existingUsuario = usuarioService.getByNombreUsuario(nombreUsuario);
	    if (existingUsuario.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);	    }
	 
	    Integer medicamentoId = receta.getMed().getMedicamentoId(); 
	   
	    Optional<Medicamento> existingMedicamento = medicamentosService.getMedicamentoById(medicamentoId);
	    if (existingMedicamento.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    receta.setUser(existingUsuario.get());
	    receta.setMed(existingMedicamento.get()); 
	   
	    /*Receta createdReceta = recetasService.createReceta(receta, existingUsuario.get(), existingMedicamento.get()); */
	    return new ResponseEntity<>(/*createdReceta, */HttpStatus.CREATED);
	}


	

}
