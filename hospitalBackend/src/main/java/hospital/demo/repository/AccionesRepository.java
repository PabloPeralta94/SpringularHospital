package hospital.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hospital.demo.model.Accion;

public interface AccionesRepository extends JpaRepository<Accion, Integer> {

}
