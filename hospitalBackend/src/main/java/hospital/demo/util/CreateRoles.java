/*
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
            Rol rolMedic = new Rol(RolNombre.ROLE_MEDIC);
            Rol rolNurse = new Rol(RolNombre.ROLE_NURSE);
            Rol rolPharma = new Rol(RolNombre.ROLE_PHARMA);
            Rol rolDirector = new Rol(RolNombre.ROLE_DIRECTOR);
            
            rolService.save(rolAdmin);
            rolService.save(rolUser);
            rolService.save(rolMedic);
            rolService.save(rolNurse);
            rolService.save(rolPharma);
            rolService.save(rolDirector);
        }
    }

    private boolean areRolesCreated() {
        return rolService.getByRolNombre(RolNombre.ROLE_ADMIN).isPresent()
                && rolService.getByRolNombre(RolNombre.ROLE_USER).isPresent()
                && rolService.getByRolNombre(RolNombre.ROLE_MEDIC).isPresent()
                && rolService.getByRolNombre(RolNombre.ROLE_NURSE).isPresent()
                && rolService.getByRolNombre(RolNombre.ROLE_PHARMA).isPresent()
                && rolService.getByRolNombre(RolNombre.ROLE_DIRECTOR).isPresent();
    }
} */