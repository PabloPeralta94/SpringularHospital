package hospital.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import hospital.demo.dto.medicamento.MedicamentoRequest;
import hospital.demo.dto.medicamento.MedicamentoResponse;
import hospital.demo.dto.receta.RecetaRequest;
import hospital.demo.dto.receta.RecetaResponse;
import hospital.demo.model.Medicamento;
import hospital.demo.security.entity.Usuario;
import hospital.demo.security.service.UsuarioService;
import hospital.demo.service.MedicamentoService;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@Transactional
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/medicamentos")
public class MedicamentosController {

    private final MedicamentoService medicamentoService;
    private final UsuarioService usuarioService;

    @Autowired
    public MedicamentosController(MedicamentoService medicamentoService, UsuarioService usuarioService) {
        this.medicamentoService = medicamentoService;
        this.usuarioService = usuarioService;
    }
    
    private static final Logger logger = LoggerFactory.getLogger(MedicamentosController.class);

    
    
    @ApiOperation("Crea un medicamento desde el usuario logueado")
    @PostMapping("/byUser")
    public ResponseEntity<MedicamentoResponse> createMedicamentoForUsuario(@Valid @RequestBody MedicamentoRequest medicamento,
                                                               Authentication authentication) {
        String nombreUsuario = authentication.getName();
        logger.info("Received a request to create a medicamento for user: {}", nombreUsuario);

        Medicamento createdMedicamento = medicamentoService.createMedicamento(medicamento);
        logger.info("Receta created successfully");

        MedicamentoResponse respuesta = medicamentoService.convertToResponse(createdMedicamento);
        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }

    
    @ApiOperation("Muestra una lista de medicamentos")
    @GetMapping
    public ResponseEntity<List<Medicamento>> getAllMedicamentos() {
        List<Medicamento> medicamentos = medicamentoService.getAllMedicamentos();
        return ResponseEntity.ok(medicamentos);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Medicamento> getMedicamentoById(@PathVariable("id") int medicamentoId) {
        Optional<Medicamento> medicamento = medicamentoService.getMedicamentoById(medicamentoId);
        return medicamento.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    
    
    @ApiOperation("Actualiza un medicamento desde su ID")
    @PutMapping("/update/{id}")
    public ResponseEntity<Medicamento> updateMedicamento(@PathVariable("id") int medicamentoId, @RequestBody Medicamento updatedMedicamento) {
        if (medicamentoService.getMedicamentoById(medicamentoId).isPresent()) {
            updatedMedicamento.setMedicamentoId(medicamentoId);
            Medicamento updated = medicamentoService.updateMedicamento(updatedMedicamento);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    @ApiOperation("Elimina un medicamento desde su ID")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMedicamento(@PathVariable("id") int medicamentoId) {
        Optional<Medicamento> medicamento = medicamentoService.getMedicamentoById(medicamentoId);
        if (medicamento.isPresent()) {
            medicamentoService.deleteMedicamento(medicamentoId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
