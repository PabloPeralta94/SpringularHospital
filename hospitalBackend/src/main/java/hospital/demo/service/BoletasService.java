package hospital.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.demo.model.Boleta;
import hospital.demo.repository.BoletasRepository;

@Service
public class BoletasService {

    private final BoletasRepository boletasRepository;

    @Autowired
    public BoletasService(BoletasRepository boletasRepository) {
        this.boletasRepository = boletasRepository;
    }

    // Create
    public Boleta createBoleta(Boleta boleta) {
        return boletasRepository.save(boleta);
    }

    // Read
    public List<Boleta> getAllBoletas() {
        return boletasRepository.findAll();
    }

    public Optional<Boleta> getBoletaById(int boletaId) {
        return boletasRepository.findById(boletaId);
    }

    // Update
    public Boleta updateBoleta(Boleta boleta) {
        return boletasRepository.save(boleta);
    }

    // Delete
    public void deleteBoletaById(int boletaId) {
        boletasRepository.deleteById(boletaId);
    }
}