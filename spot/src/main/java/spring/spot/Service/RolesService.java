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

    public Roles getRolesByName(String name) {
        Optional<Roles> optionalRoles = rolesRepository.findById(name);
        if (!optionalRoles.isPresent())
            throw new RolesException("No such roles found");
        return rolesRepository.findById(name).get();
    }


    public Roles updateRolesByName(String name, Roles roles) {
        Optional<Roles> optionalRoles = rolesRepository.findById(name);
        if (!optionalRoles.isPresent())
            throw new RolesException("No such roles found");
        roles.setRole_name(name);
        return rolesRepository.save(roles);
    }

    public void deleteRolesByName(String name) {
        Optional<Roles> optionalRoles = rolesRepository.findById(name);
        if (!optionalRoles.isPresent())
            throw new RolesException("No such roles found");
        rolesRepository.deleteById(name);
    }
}