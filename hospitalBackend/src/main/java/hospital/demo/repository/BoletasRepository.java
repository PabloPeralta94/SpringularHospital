package hospital.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hospital.demo.model.Boleta;

public interface BoletasRepository extends JpaRepository<Boleta, Integer> {

}
