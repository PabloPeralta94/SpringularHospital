package hospital.demo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import hospital.demo.model.Turno;
import hospital.demo.security.entity.Usuario;


public interface TurnosRepository extends JpaRepository<Turno, Integer> {

	List<Turno> findByUser(Usuario usuario);

}
