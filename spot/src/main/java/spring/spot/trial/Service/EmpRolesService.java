package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.EmpRoles;
import spring.spot.trial.Exception.InputValidationException;
import spring.spot.trial.Exception.NotFoundException;
import spring.spot.trial.Repository.EmpRolesRepository;

import java.util.List;

@Service
public class EmpRolesService {
    @Autowired
    EmpRolesRepository empRolesRepository;

    public EmpRolesService(EmpRolesRepository empRolesRepository) {
        this.empRolesRepository = empRolesRepository;
    }

    public EmpRoles createEmpRoles(EmpRoles emp) {
        return empRolesRepository.save(emp);
    }

    public List<EmpRoles> getAllEmpRoles() {
        List<EmpRoles> roles = empRolesRepository.findAll();
        if(roles.isEmpty())
            throw new NotFoundException("No such role found!");
        return roles;
    }

    public List<EmpRoles> getEmpRolesById(String id) {
        InputValidationException.validateInputParameter(id);
        List<EmpRoles> roles = empRolesRepository.findByEmpId(id);
        if(roles.isEmpty())
            throw new NotFoundException("No such role for id "+id+" found");
        return roles;
    }

    public EmpRoles updateEmpRolesById(String id, EmpRoles emproles) {
        InputValidationException.validateInputParameter(id);
        List<EmpRoles> roles = empRolesRepository.findByEmpId(id);
        if(roles.isEmpty())
            throw new NotFoundException("No such role for id "+id+" found");
        return empRolesRepository.save(emproles);
    }

}
