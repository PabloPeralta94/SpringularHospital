package hospital.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hospital.demo.model.Tarea;
import hospital.demo.security.entity.Usuario;

public interface TareaRepository extends JpaRepository<Tarea, Integer> {

	List<Tarea> findByUsuario(Usuario usuario);

}
