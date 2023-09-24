package hospital.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hospital.demo.model.Medicamento;


public interface MedicamentosRepository extends JpaRepository<Medicamento, Integer> {

}
