package hospital.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import hospital.demo.model.Medicamento;
import hospital.demo.model.Receta;
import hospital.demo.repository.MedicamentosRepository;
import hospital.demo.repository.RecetasRepository;
import hospital.demo.security.entity.Usuario;
import hospital.demo.security.repository.UsuarioRepository;

@Service
public class RecetasService {
	
	private final RecetasRepository recetasRepository;
	private final UsuarioRepository usuarioRepository;
	private final MedicamentosRepository medicamentosRepository; // You'll need the MedicamentoRepository

	@Autowired
	public RecetasService(RecetasRepository recetasRepository, UsuarioRepository usuarioRepository, MedicamentosRepository medicamentosRepository) {
		this.recetasRepository = recetasRepository;
		this.usuarioRepository = usuarioRepository;
		this.medicamentosRepository = medicamentosRepository;
	}

	public List<Receta> getAllRecetas() {
		return recetasRepository.findAll();
	}

	public Optional<Receta> getRecetaById(Integer recetaId) {
		return recetasRepository.findById(recetaId);
	}

	public Receta createReceta(Receta receta, String nombreUsuario, int medicamentoId) {
		Usuario usuario = usuarioRepository.findByNombreUsuario(nombreUsuario)
				.orElseThrow(() -> new IllegalArgumentException("Usuario with nombreUsuario " + nombreUsuario + " not found."));

		Medicamento medicamento = medicamentosRepository.findById(medicamentoId)
				.orElseThrow(() -> new IllegalArgumentException("Medicamento with ID " + medicamentoId + " not found."));

		receta.setPaciente(nombreUsuario);
		receta.setProfesional(usuario.getNombreUsuario());
		receta.setMedicamento(medicamento); 
		return recetasRepository.save(receta);
	}

	public Receta updateReceta(Receta receta) {
		return recetasRepository.save(receta);
	}

	public void deleteReceta(Integer recetaId) {
		recetasRepository.deleteById(recetaId);
	}

	public Page<Receta> getPaginatedRecetas(Pageable pageable) {
		return recetasRepository.findAll(pageable);
	}
}
