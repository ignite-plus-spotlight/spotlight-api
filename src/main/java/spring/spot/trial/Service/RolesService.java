package spring.spot.trial.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.Roles;
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
        return rolesRepository.findAll();
    }

    public Roles getAllRolesByName(String name) {
        return rolesRepository.findByRoleName(name);
    }



    public Roles updateRolesByName(String name, Roles roles) {
        return rolesRepository.save(roles);
    }

    public void deleteRolesByName(String name) {
        rolesRepository.deleteById(name);
    }
}
