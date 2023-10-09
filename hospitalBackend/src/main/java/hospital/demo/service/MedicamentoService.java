package hospital.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.demo.model.Medicamento;
import hospital.demo.repository.MedicamentosRepository;


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

    public Medicamento createMedicamento(Medicamento medicamento) {
    	
        return medicamentosRepository.save(medicamento);
    }

    public Medicamento updateMedicamento(Medicamento medicamento) {
        return medicamentosRepository.save(medicamento);
    }

    public void deleteMedicamento(int medicamentoId) {
    	medicamentosRepository.deleteById(medicamentoId);
    }

}
