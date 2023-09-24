package hospital.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import hospital.demo.model.Medicamento;
import hospital.demo.service.MedicamentosService;

import java.util.List;
import java.util.Optional;

@RestController
@Transactional
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/medicamentos")
public class MedicamentosController {

    private final MedicamentosService medicamentosService;

    @Autowired
    public MedicamentosController(MedicamentosService medicamentosService) {
        this.medicamentosService = medicamentosService;
    }

   
    @PostMapping("/crear")
    public ResponseEntity<Medicamento> createMedicamento(@RequestBody Medicamento medicamento) {
        Medicamento createdMedicamento = medicamentosService.createMedicamento(medicamento);
        return new ResponseEntity<>(createdMedicamento, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Medicamento>> getAllMedicamentos() {
        List<Medicamento> medicamentos = medicamentosService.getAllMedicamentos();
        return new ResponseEntity<>(medicamentos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicamento> getMedicamentoById(@PathVariable("id") int medicamentoId) {
        Optional<Medicamento> medicamento = medicamentosService.getMedicamentoById(medicamentoId);
        return medicamento.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

   
    @PutMapping("/update/{id}")
    public ResponseEntity<Medicamento> updateMedicamento(@PathVariable("id") int medicamentoId, @RequestBody Medicamento updatedMedicamento) {
        if (medicamentosService.getMedicamentoById(medicamentoId).isPresent()) {
            updatedMedicamento.setMedicamentoId(medicamentoId); 
            Medicamento updated = medicamentosService.updateMedicamento(updatedMedicamento);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMedicamento(@PathVariable("id") int medicamentoId) {
        Optional<Medicamento> medicamento = medicamentosService.getMedicamentoById(medicamentoId);
        if (medicamento.isPresent()) {
            medicamentosService.deleteMedicamento(medicamentoId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
