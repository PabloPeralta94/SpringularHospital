package hospital.demo.security.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hospital.demo.security.entity.Usuario;
import hospital.demo.security.enums.RolNombre;

import java.util.Optional;
import java.util.Set;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByEmail(String email);
	Page<Usuario> findAll(Pageable pageable);
	Page<Usuario> findByRoles_RolNombre(RolNombre rolNombreEnum, Pageable pageable);
}
