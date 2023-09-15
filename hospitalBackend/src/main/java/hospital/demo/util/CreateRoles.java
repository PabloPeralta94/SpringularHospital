package hospital.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import hospital.demo.security.entity.Rol;
import hospital.demo.security.enums.RolNombre;
import hospital.demo.security.service.RolService;

@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    private RolService rolService;

    @Override
    public void run(String... args) throws Exception {
        if (!areRolesCreated()) {
            Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
            Rol rolUser = new Rol(RolNombre.ROLE_USER);
            rolService.save(rolAdmin);
            rolService.save(rolUser);
        }
    }

    private boolean areRolesCreated() {
        return rolService.getByRolNombre(RolNombre.ROLE_ADMIN).isPresent()
                && rolService.getByRolNombre(RolNombre.ROLE_USER).isPresent();
    }
}
