package spring.spot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.Entity.Roles;
import spring.spot.Exception.RolesException;
import spring.spot.Repository.RolesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RolesService {

    @Autowired
    private RolesRepository rolesRepository;

    public RolesService(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }


    public Roles createRoles(Roles roles) {
        return rolesRepository.save(roles);
    }


    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }

    public List<Roles> getRolesByName(String name) {
        List<Roles> optionalRoles = rolesRepository.findByRolesKeyRoleName(name);
        if (optionalRoles == null)
            throw new RolesException("No such role found");
        return rolesRepository.findByRolesKeyRoleName(name);
    }


    public Roles updateRolesByName(String name, Roles roles) {
        return rolesRepository.save(roles);
    }

}