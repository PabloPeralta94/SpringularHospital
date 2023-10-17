package hospital.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import hospital.demo.dto.receta.RecetaRequest;
import hospital.demo.dto.tarea.TareaRequest;
import hospital.demo.dto.tarea.TareaResponse;
import hospital.demo.dto.turno.TurnoRequest;
import hospital.demo.dto.turno.TurnoResponse;
import hospital.demo.model.Medicamento;
import hospital.demo.model.Receta;
import hospital.demo.model.Tarea;
import hospital.demo.model.Turno;
import hospital.demo.repository.TareaRepository;
import hospital.demo.repository.TurnosRepository;
import hospital.demo.security.entity.Usuario;
import hospital.demo.security.repository.UsuarioRepository;

@Service
@Transactional
public class TareaService {
	
	private final TareaRepository tareaRepository;
	private final UsuarioRepository usuarioRepository;
	
	@Autowired
    public TareaService(TareaRepository tareaRepository, UsuarioRepository usuarioRepository) {
        this.tareaRepository = tareaRepository;
        this.usuarioRepository = usuarioRepository;    } 
	
	public List<Tarea> getAllTareas() {
		 
		return tareaRepository.findAll();
	}
	
	public Optional<Tarea> getTurnosById(int tareaId) {
        return tareaRepository.findById(tareaId);
    }
	
	public Tarea createTarea(TareaRequest tareaRequest, Usuario usuario) {
    	Tarea nuevaTarea = new Tarea();
    	
    	nuevaTarea.setNombre(tareaRequest.getNombre());
    	nuevaTarea.setDescripcion(tareaRequest.getDescripcion());
    	nuevaTarea.setEnfermeraAsignada(tareaRequest.getEnfermeraAsignada());
    	nuevaTarea.setPrioridad(tareaRequest.getPrioridad());
    	nuevaTarea.setPacienteAsociado(tareaRequest.getPacienteAsociado());
    	nuevaTarea.setUbicacion(tareaRequest.getUbicacion());
    	nuevaTarea.setNotas(tareaRequest.getNotas());   	
    	
    	nuevaTarea.setUsuario(usuario);
    	tareaRepository.save(nuevaTarea);
    	
        return nuevaTarea;
    }
	
	@Transactional
	public Tarea updateTarea(Tarea tarea, TareaRequest tareaRequest) {			   
		
		   tarea.setNombre (tareaRequest.getNombre());
		   tarea.setDescripcion(tareaRequest.getDescripcion());
		   tarea.setEnfermeraAsignada(tareaRequest.getEnfermeraAsignada());
		   tarea.setPrioridad(tareaRequest.getPrioridad());
		   tarea.setPacienteAsociado(tareaRequest.getPacienteAsociado());
		   tarea.setUbicacion(tareaRequest.getUbicacion());
		   tarea.setNotas(tareaRequest.getNotas());
		   
	       return tareaRepository.save(tarea);
	    } 
	
	
	public void deleteTarea(int tareaId) {
        tareaRepository.deleteById(tareaId);
    }
	
	public Page<Tarea> getPaginatedTurnos(Pageable pageable) {
        return tareaRepository.findAll(pageable);
    }
	
public TareaResponse convertToResponse(Tarea tarea) {
		
		TareaResponse tareaResponse = new TareaResponse();
		
		tareaResponse.setTareaId(tarea.getTareaId());
		tareaResponse.setNombre(tarea.getNombre());
		tareaResponse.setDescripcion(tarea.getDescripcion());
		tareaResponse.setFechaInicio(tarea.getFechaInicio());
		tareaResponse.setFechaFin(tarea.getFechaFin());
		tareaResponse.setEnfermeraAsignada(tarea.getEnfermeraAsignada());
		tareaResponse.setEstado(tarea.getEstado());
		tareaResponse.setPrioridad(tarea.getPrioridad());
		tareaResponse.setPacienteAsociado(tarea.getPacienteAsociado());
		tareaResponse.setUbicacion(tarea.getUbicacion());
		tareaResponse.setNotas(tarea.getNotas());
		tareaResponse.setUsuarioId(tarea.getUsuario().getId());	
		
		return tareaResponse;
	}

    public List<Tarea> getTareasByUsuario(Usuario usuario) {
    // Assuming you have a TurnoRepository to interact with the database
    return tareaRepository.findByUsuario(usuario);
}

	public Optional<Tarea> getTareaById(Integer tareaId) {		
		return tareaRepository.findById(tareaId);
	}

	}



