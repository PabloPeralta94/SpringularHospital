package hospital.demo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import hospital.demo.model.Turno;


public interface TurnosRepository extends JpaRepository<Turno, Long> {

	List getTurnosByNombreUsuario(String nombreUsuario);

	List getAllTurnos();

	List<Turno> findTurnosByUser_NombreUsuario(String user, Object object);

	List<Turno> findByTitleContainingIgnoreCase(String title);

	List<Turno> findByUser_NombreUsuarioAndTitleContainingIgnoreCase(String user, String title);

}
