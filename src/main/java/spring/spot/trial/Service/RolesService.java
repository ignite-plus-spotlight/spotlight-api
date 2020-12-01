package spring.spot.trial.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.Roles;
import spring.spot.trial.Exception.NotFoundException;
import spring.spot.trial.Repository.RolesRepository;

import java.util.List;

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
        List<Roles> roles = rolesRepository.findAll();
        if(roles.isEmpty())
            throw new NotFoundException("No such role found!");
        return roles;
    }

    public Roles getAllRolesByName(String name) {
        Roles roles = rolesRepository.findByRoleName(name);
        if(roles == null)
            throw new NotFoundException("No role with name "+name+" found!");
        return roles;
    }
}
