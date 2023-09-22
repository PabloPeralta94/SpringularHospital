package hospital.demo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import hospital.demo.model.Turno;


public interface TurnosRepository extends JpaRepository<Turno, Integer> {

}
