package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.CertGenerate;
import spring.spot.trial.Entity.Employee;
import spring.spot.trial.Entity.EmployeeAwardsMD;
import spring.spot.trial.Entity.EmployeeAwardsTM;
import spring.spot.trial.Repository.EmployeeAwardsMRepository;
import spring.spot.trial.Repository.EmployeeAwardsTMRepository;
import spring.spot.trial.Repository.EmployeeRepository;
import spring.spot.trial.dto.AwardsGivenByManagerDTO;
import spring.spot.trial.dto.EmpAwardWinnersUnderManagerDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeAwardsService {
    @Autowired
    EmployeeAwardsTMRepository employeeAwardsTMRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeAwardsMRepository employeeAwardsMRepository;

    public EmployeeAwardsService(EmployeeAwardsTMRepository employeeAwardsTMRepository) { this.employeeAwardsTMRepository = employeeAwardsTMRepository; }

    public EmployeeAwardsTM createEmployeeAwards(EmployeeAwardsTM emp) throws Exception {
        EmployeeAwardsTM employeeAwardsTM = employeeAwardsTMRepository.save(emp);
        Employee employee = employeeRepository.findByEmpId(employeeAwardsTM.getEmpId()).get(0);
        String id = employeeAwardsTM.getEmpId();
        EmployeeAwardsTM etm = employeeAwardsTMRepository.findByEmpId(id).get(0);
        EmployeeAwardsMD emd = new EmployeeAwardsMD();
        emd.setAwardedById(etm.getAwardedById());
        emd.setAwardName(etm.getAwardName());
        emd.setDepartment(etm.getDepartment());
        emd.setDescription(etm.getDescription());
        emd.setEmpId(etm.getEmpId());
        emd.setEmpPoints(etm.getEmpPoints());
        emd.setImgsrc(etm.getImgsrc());
        emd.setManagerName(etm.getManagerName());
        emd.setPeriodName(etm.getPeriodName());
        emd.setTimestamp(etm.getTimestamp());
        employeeAwardsMRepository.save(emd);



        CertGenerate.certGenerate(employee, employeeAwardsTM);

        return employeeAwardsTM;
    }


    public List<EmployeeAwardsTM> getAllEmployeeAwards() {
        return employeeAwardsTMRepository.findAll();
    }

    public List<EmployeeAwardsTM> getEmployeeAwardsById(String id) { return employeeAwardsTMRepository.findByEmpId(id); }

    public EmployeeAwardsTM updateEmployeeAwardsById(String id, EmployeeAwardsTM emp) { return employeeAwardsTMRepository.save(emp); }

    public List<EmployeeAwardsMD> getEmployeeAwardsMByManagerId(String id)
    {
        return employeeAwardsMRepository.findByAwardedById(id);
    }

    public AwardsGivenByManagerDTO getWinnersUnderManager(String managerId)
    {
        AwardsGivenByManagerDTO awardsGivenByManagerDTO = new AwardsGivenByManagerDTO();
        List<EmployeeAwardsMD> employeeAwardsMDS = employeeAwardsMRepository.findByAwardedById(managerId);
        awardsGivenByManagerDTO.setEmployee(employeeRepository.findByEmpId(managerId).get(0));
        EmpAwardWinnersUnderManagerDTO empAwardWinnersUnderManagerDTO = new EmpAwardWinnersUnderManagerDTO();
        List<EmpAwardWinnersUnderManagerDTO> empAwardWinnersUnderManagerDTOS = new ArrayList<>();
        for (EmployeeAwardsMD e : employeeAwardsMDS)
        {
            empAwardWinnersUnderManagerDTO.setAwardedById(e.getAwardedById());
            empAwardWinnersUnderManagerDTO.setAwardName(e.getAwardName());
            empAwardWinnersUnderManagerDTO.setDepartment(e.getDepartment());
            empAwardWinnersUnderManagerDTO.setDescription(e.getDescription());
            empAwardWinnersUnderManagerDTO.setEmpPoints(e.getEmpPoints());
            empAwardWinnersUnderManagerDTO.setImgsrc(e.getImgsrc());
            empAwardWinnersUnderManagerDTO.setManagerName(e.getManagerName());
            empAwardWinnersUnderManagerDTO.setPeriodName(e.getPeriodName());
            empAwardWinnersUnderManagerDTO.setTimestamp(e.getTimestamp());
            empAwardWinnersUnderManagerDTO.setEmpId(e.getEmpId());
            String empId = e.getEmpId();
            empAwardWinnersUnderManagerDTO.setEmployee(employeeRepository.findByEmpId(empId).get(0));
            empAwardWinnersUnderManagerDTOS.add(empAwardWinnersUnderManagerDTO);
        }
        awardsGivenByManagerDTO.setEmpAwardWinnersUnderManagerDTOS(empAwardWinnersUnderManagerDTOS);
        return awardsGivenByManagerDTO;
    }
}
