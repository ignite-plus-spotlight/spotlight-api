package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.EmpRoles;
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
        return empRolesRepository.findAll();
    }

    public List<EmpRoles> getEmpRolesById(String id) {
        return empRolesRepository.findByEmpId(id);
    }

    public EmpRoles updateEmpRolesById(String id, EmpRoles emproles) {
        return empRolesRepository.save(emproles);
    }

}
