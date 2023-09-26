package hospital.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hospital.demo.model.Receta;

public interface RecetasRepository extends JpaRepository<Receta, Integer> {

}
