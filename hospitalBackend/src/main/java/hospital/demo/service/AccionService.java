package hospital.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.demo.model.Accion;
import hospital.demo.repository.AccionesRepository;

@Service
public class AccionService {

    private final AccionesRepository accionesRepository;

    @Autowired
    public AccionService(AccionesRepository accionesRepository) {
        this.accionesRepository = accionesRepository;
    }

    // Create a new Accion
    public Accion createAccion(Accion accion) {
        return accionesRepository.save(accion);
    }

    // Retrieve all Acciones
    public List<Accion> getAllAcciones() {
        return accionesRepository.findAll();
    }

    // Retrieve an Accion by its ID
    public Optional<Accion> getAccionById(int accionId) {
        return accionesRepository.findById(accionId);
    }

    // Update an existing Accion
    public Accion updateAccion(int accionId, Accion updatedAccion) {
        Optional<Accion> existingAccion = accionesRepository.findById(accionId);
        if (existingAccion.isPresent()) {
            updatedAccion.setAccionId(accionId);
            return accionesRepository.save(updatedAccion);
        } else {
            // Handle the case where the Accion with the given ID does not exist.
            return null;
        }
    }

    // Delete an Accion by its ID
    public void deleteAccion(int accionId) {
        accionesRepository.deleteById(accionId);
    }
}