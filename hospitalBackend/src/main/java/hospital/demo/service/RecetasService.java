package hospital.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import hospital.demo.model.Medicamento;
import hospital.demo.model.Receta;
import hospital.demo.repository.MedicamentosRepository;
import hospital.demo.repository.RecetasRepository;
import hospital.demo.security.entity.Usuario;
import hospital.demo.security.repository.UsuarioRepository;



@Service
@Transactional
public class RecetasService {
	private final UsuarioRepository usuarioRepository;
	private final MedicamentosRepository medicamentosRepository;
	private final RecetasRepository recetasRepository;
	
	@Autowired
	public RecetasService(UsuarioRepository usuarioRepository, MedicamentosRepository medicamentosRepository, RecetasRepository recetasRepository) {
		this.usuarioRepository = usuarioRepository;
		this.medicamentosRepository = medicamentosRepository;
		this.recetasRepository = recetasRepository;
	}
	
	public List<Receta> getAllRecetas() {
		return recetasRepository.findAll();
	}
	
	public Receta createReceta(Receta receta, Usuario usuario, Medicamento medicamento) {
        receta.setUser(usuario);
        receta.setMed(medicamento);
        return recetasRepository.save(receta);
    }
	
	public Receta updateReceta(Receta receta) {
        return recetasRepository.save(receta);
    }
	
	public void deleteReceta(Integer recetaId) {
        recetasRepository.deleteById(recetaId);
    }


}
