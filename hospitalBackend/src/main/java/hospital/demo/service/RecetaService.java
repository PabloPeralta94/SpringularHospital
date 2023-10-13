package hospital.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hospital.demo.dto.receta.RecetaRequest;
import hospital.demo.dto.receta.RecetaResponse;
import hospital.demo.model.Medicamento;
import hospital.demo.model.Receta;
import hospital.demo.repository.MedicamentosRepository;
import hospital.demo.repository.RecetasRepository;
import hospital.demo.security.entity.Usuario;
import hospital.demo.security.repository.UsuarioRepository;



@Service
@Transactional
public class RecetaService {
	private final UsuarioRepository usuarioRepository;
	private final MedicamentosRepository medicamentosRepository;
	private final RecetasRepository recetasRepository;
	
	@Autowired
	public RecetaService(UsuarioRepository usuarioRepository, MedicamentosRepository medicamentosRepository, RecetasRepository recetasRepository) {
		this.usuarioRepository = usuarioRepository;
		this.medicamentosRepository = medicamentosRepository;
		this.recetasRepository = recetasRepository;
	}
	
	public List<Receta> getAllRecetas() {
		return recetasRepository.findAll();
	}
	
	public Receta createReceta(RecetaRequest recetaRequest, Usuario usuario, Medicamento medicamento) {   
		Receta nuevaReceta = new Receta();	
		
		nuevaReceta.setConsultorio(recetaRequest.getConsultorio());
		nuevaReceta.setUser(usuario);
		nuevaReceta.setMed(medicamento);
		nuevaReceta.setEstaAprobada(false);
        return recetasRepository.save(nuevaReceta);
    }
	
	@Transactional
	public Receta updateReceta(Receta receta, RecetaRequest recetaRequest) {		
		   Medicamento medicamento = medicamentosRepository.getById(recetaRequest.getMedicamentoId());
		
		   receta.setConsultorio(recetaRequest.getConsultorio());
		   receta.setMed(medicamento); 
	       return recetasRepository.save(receta);
	    } 
	

	
	public void deleteReceta(Integer recetaId) {
        recetasRepository.deleteById(recetaId);
    }
	
	public RecetaResponse convertToResponse(Receta receta) {	
	    RecetaResponse recetaResponse = new RecetaResponse();
	
	    recetaResponse.setRecetaId(receta.getRecetaId());
	    recetaResponse.setConsultorio(receta.getConsultorio());
	    recetaResponse.setUsuarioId(receta.getUser().getId());
	    recetaResponse.setMedicamentoId(receta.getMed().getMedicamentoId());
	    recetaResponse.setEstaAprobado(receta.getEstaAprobada());
	 
	    return recetaResponse;
	}

	public Optional<Receta> getRecetaById(Integer recetaId) {		
		return recetasRepository.findById(recetaId);
	}



}
