package hospital.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.demo.dto.medicamento.MedicamentoRequest;
import hospital.demo.dto.medicamento.MedicamentoResponse;
import hospital.demo.dto.receta.RecetaRequest;
import hospital.demo.dto.receta.RecetaResponse;
import hospital.demo.model.Medicamento;
import hospital.demo.model.Receta;
import hospital.demo.repository.MedicamentosRepository;
import hospital.demo.security.entity.Usuario;


@Service
public class MedicamentoService {
	private final MedicamentosRepository medicamentosRepository;
	
	@Autowired
    public MedicamentoService(MedicamentosRepository medicamentosRepository) {
       this.medicamentosRepository = medicamentosRepository;   } 
	
	public List<Medicamento> getAllMedicamentos() {
		 
		return medicamentosRepository.findAll();
	}
  
    

    public Optional<Medicamento> getMedicamentoById(Integer medicamentoId) {
        return medicamentosRepository.findById(medicamentoId);
    }

    public Medicamento createMedicamento(MedicamentoRequest medicamentoRequest) {   
		Medicamento nuevoMedicamento = new Medicamento();	
		
		nuevoMedicamento.setNombre(medicamentoRequest.getNombre());		
		nuevoMedicamento.setDescripcion(medicamentoRequest.getDescripcion());
		nuevoMedicamento.setPrecio(medicamentoRequest.getPrecio());
		nuevoMedicamento.setEsVentaLibre(medicamentoRequest.getEsVentaLibre());
		
        return medicamentosRepository.save(nuevoMedicamento);
    }

    public Medicamento updateMedicamento(Medicamento medicamento) {
        return medicamentosRepository.save(medicamento);
    }

    public void deleteMedicamento(int medicamentoId) {
    	medicamentosRepository.deleteById(medicamentoId);
    }
    
    public MedicamentoResponse convertToResponse(Medicamento medicamento) {	
	    MedicamentoResponse medicamentoResponse = new MedicamentoResponse();
	    
	    medicamentoResponse.setMedicamentoId(medicamento.getMedicamentoId());	
	    medicamentoResponse.setNombre(medicamento.getNombre());
	    medicamentoResponse.setDescripcion(medicamento.getDescripcion());
	    medicamentoResponse.setPrecio(medicamento.getPrecio());
	    medicamentoResponse.setEsVentaLibre(medicamento.getEsVentaLibre());
	    	 
	    return medicamentoResponse;
	}

}
