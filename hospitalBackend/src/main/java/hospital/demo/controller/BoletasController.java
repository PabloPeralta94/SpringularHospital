package hospital.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hospital.demo.model.Boleta;
import hospital.demo.service.BoletasService;

@RestController
@RequestMapping("/boletas")
public class BoletasController {

    private final BoletasService boletasService;

    @Autowired
    public BoletasController(BoletasService boletasService) {
        this.boletasService = boletasService;
    }

    // Create a new Boleta
    @PostMapping("/")
    public ResponseEntity<Boleta> createBoleta(@RequestBody Boleta boleta) {
        Boleta createdBoleta = boletasService.createBoleta(boleta);
        return new ResponseEntity<>(createdBoleta, HttpStatus.CREATED);
    }

    // Read all Boletas
    @GetMapping("/")
    public ResponseEntity<List<Boleta>> getAllBoletas() {
        List<Boleta> boletas = boletasService.getAllBoletas();
        return new ResponseEntity<>(boletas, HttpStatus.OK);
    }

    // Read a specific Boleta by ID
    @GetMapping("/{boletaId}")
    public ResponseEntity<Boleta> getBoletaById(@PathVariable int boletaId) {
        Optional<Boleta> boleta = boletasService.getBoletaById(boletaId);
        return boleta.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update an existing Boleta
    @PutMapping("/{boletaId}")
    public ResponseEntity<Boleta> updateBoleta(@PathVariable int boletaId, @RequestBody Boleta boleta) {
        if (boletasService.getBoletaById(boletaId).isPresent()) {
            boleta.setBoletaId(boletaId);
            Boleta updatedBoleta = boletasService.updateBoleta(boleta);
            return new ResponseEntity<>(updatedBoleta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a Boleta by ID
    @DeleteMapping("/{boletaId}")
    public ResponseEntity<Void> deleteBoleta(@PathVariable int boletaId) {
        boletasService.deleteBoletaById(boletaId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}