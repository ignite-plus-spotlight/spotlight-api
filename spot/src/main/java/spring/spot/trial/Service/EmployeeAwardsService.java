package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.CertGenerate;
import spring.spot.trial.Entity.Employee;
import spring.spot.trial.Entity.EmployeeAwardsMD;
import spring.spot.trial.Entity.EmployeeAwardsTM;
import spring.spot.trial.Entity.Team;
import spring.spot.trial.Repository.EmployeeAwardsMRepository;
import spring.spot.trial.Repository.EmployeeAwardsTMRepository;
import spring.spot.trial.Repository.EmployeeRepository;
import spring.spot.trial.Repository.TeamRepository;
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

    @Autowired
    TeamRepository teamRepository;

    public EmployeeAwardsService(EmployeeAwardsTMRepository employeeAwardsTMRepository) { this.employeeAwardsTMRepository = employeeAwardsTMRepository; }

    public EmployeeAwardsTM createEmployeeAwards(EmployeeAwardsTM emp) throws Exception {
        EmployeeAwardsTM employeeAwardsTM = employeeAwardsTMRepository.save(emp);
        /************For certificate**************/
        Employee employee = employeeRepository.findByEmpId(employeeAwardsTM.getEmpId()).get(0);
        /*****************************************/
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

//        CertGenerate.certGenerate(employee, employeeAwardsTM);

        return employeeAwardsTM;
    }


    public List<EmployeeAwardsTM> getAllEmployeeAwards(){
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
        awardsGivenByManagerDTO.setEmployee(employeeRepository.findByEmpId(managerId).get(0));
        List<EmpAwardWinnersUnderManagerDTO> empAwardWinnersUnderManagerDTOS = new ArrayList<>();
        List<Team> teams = teamRepository.findByManagerId(managerId);
        for (Team t : teams)     //All teams under manager
        {
            List<String> members = t.getMembers();

            for (String empId : members)   //All members under this team
            {
                EmpAwardWinnersUnderManagerDTO edto = new EmpAwardWinnersUnderManagerDTO();
                Employee employee = employeeRepository.findByEmpId(empId).get(0);
                edto.setEmployee(employee);
                List<EmployeeAwardsTM> etms = employeeAwardsTMRepository.findByEmpId(empId);//All awards of this member
                if(!etms.isEmpty()) {
                    edto.setEmployeeAwardsTMS(etms);
                    empAwardWinnersUnderManagerDTOS.add(edto);
                }
            }
        }
        awardsGivenByManagerDTO.setEmpAwardWinnersUnderManagerDTOS(empAwardWinnersUnderManagerDTOS);
        return awardsGivenByManagerDTO;
    }
}
