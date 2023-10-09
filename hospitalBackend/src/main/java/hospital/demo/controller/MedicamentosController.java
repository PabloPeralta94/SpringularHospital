package hospital.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import hospital.demo.model.Medicamento;
import hospital.demo.service.MedicamentoService;

import java.util.List;
import java.util.Optional;

@RestController
@Transactional
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/medicamentos")
public class MedicamentosController {

    private final MedicamentoService medicamentoService;

    @Autowired
    public MedicamentosController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    /**
     * Create a new Medicamento.
     */
    @PostMapping("/crear")
    public ResponseEntity<Medicamento> createMedicamento(@RequestBody Medicamento medicamento) {
        Medicamento createdMedicamento = medicamentoService.createMedicamento(medicamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMedicamento);
    }

    /**
     * Get a list of all Medicamentos.
     */
    @GetMapping
    public ResponseEntity<List<Medicamento>> getAllMedicamentos() {
        List<Medicamento> medicamentos = medicamentoService.getAllMedicamentos();
        return ResponseEntity.ok(medicamentos);
    }

    /**
     * Get a Medicamento by its ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Medicamento> getMedicamentoById(@PathVariable("id") int medicamentoId) {
        Optional<Medicamento> medicamento = medicamentoService.getMedicamentoById(medicamentoId);
        return medicamento.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Update an existing Medicamento.
     */
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

    /**
     * Delete a Medicamento by its ID.
     */
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
