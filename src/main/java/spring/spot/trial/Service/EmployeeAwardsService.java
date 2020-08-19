package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.*;
import spring.spot.trial.Exception.InputValidationException;
import spring.spot.trial.Exception.NotFoundException;
import spring.spot.trial.Repository.*;
import spring.spot.trial.dto.AwardsGivenByHeadDTO;
import spring.spot.trial.dto.EmpAwardWinnersUnderHeadDTO;

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
    AwardToIndividualRepository awardToIndividualRepository;

    @Autowired
    TeamRepository teamRepository;

    public EmployeeAwardsService(EmployeeAwardsTMRepository employeeAwardsTMRepository) { this.employeeAwardsTMRepository = employeeAwardsTMRepository; }

    public EmployeeAwardsTM createEmployeeAwards(String empId, String headId, String awardName, String periodName, String department) throws Exception {
        EmployeeAwardsTM emp = new EmployeeAwardsTM();
        AwardToIndividual awardToIndividual = awardToIndividualRepository.findByAwardName(awardName);
        Employee employee1 = employeeRepository.findByEmpId(headId).get(0);
        emp.setAwardedById(headId);
        emp.setAwardName(awardName);
        emp.setDepartment(department);
        emp.setDescription(awardToIndividual.getDescription());
        emp.setEmpId(empId);
        emp.setEmpPoints(awardToIndividual.getPoints());
        emp.setImgsrc(awardToIndividual.getImgsrc());
        emp.setHeadName(employee1.getFirstName()+" "+employee1.getLastName());
        emp.setPeriodName(periodName);
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
        emd.setHeadName(etm.getHeadName());
        emd.setPeriodName(etm.getPeriodName());
        emd.setTimestamp(etm.getTimestamp());
        employeeAwardsMRepository.save(emd);

//        CertGenerate.certGenerate(employee, employeeAwardsTM);

        return employeeAwardsTM;
    }


    public List<EmployeeAwardsTM> getAllEmployeeAwards(){
        List<EmployeeAwardsTM> employeesAwards = employeeAwardsTMRepository.findAll();
        if(employeesAwards.isEmpty())
            throw new NotFoundException("Employee Award not found");
        return employeesAwards;
    }

    public List<EmployeeAwardsTM> getEmployeeAwardsById(String id) {
        InputValidationException.validateInputParameter(id);
        List<EmployeeAwardsTM> employeesAwards = employeeAwardsTMRepository.findByEmpId(id);
        if(employeesAwards.isEmpty())
            throw new NotFoundException("Employee Award not found for id:"+id);
        return employeesAwards; }

    public EmployeeAwardsTM updateEmployeeAwardsById(String id, EmployeeAwardsTM emp) {
        InputValidationException.validateInputParameter(id);
        List<EmployeeAwardsTM> employees = employeeAwardsTMRepository.findByEmpId(id);
        if(employees.isEmpty())
            throw new NotFoundException("Employee Award not found for id: "+id);
        return employeeAwardsTMRepository.save(emp); }

    public List<EmployeeAwardsMD> getEmployeeAwardsMByHeadId(String id) {
        InputValidationException.validateInputParameter(id);
        List<EmployeeAwardsMD> employeesAwards = employeeAwardsMRepository.findByAwardedById(id);
        if(employeesAwards.isEmpty())
            throw new NotFoundException("Head not found for id: "+id);
        return employeesAwards;
    }




    public AwardsGivenByHeadDTO getWinnersUnderHead(String headId)
    {
        AwardsGivenByHeadDTO awardsGivenByHeadDTO = new AwardsGivenByHeadDTO();
        awardsGivenByHeadDTO.setEmployee(employeeRepository.findByEmpId(headId).get(0));
        List<EmpAwardWinnersUnderHeadDTO> empAwardWinnersUnderHeadDTOS = new ArrayList<>();
        List<Team> teams = teamRepository.findByHeadId(headId);
        for (Team t : teams)     //All teams under manager
        {
            List<String> members = t.getMembers();

            for (String empId : members)     //All members under this team
            {
                EmpAwardWinnersUnderHeadDTO edto = new EmpAwardWinnersUnderHeadDTO();
                Employee employee = employeeRepository.findByEmpId(empId).get(0);
                edto.setEmployee(employee);
                List<EmployeeAwardsTM> etms = employeeAwardsTMRepository.findByEmpId(empId);    //All awards of this member
                if(!etms.isEmpty()) {
                    edto.setEmployeeAwardsTMS(etms);
                    empAwardWinnersUnderHeadDTOS.add(edto);
                }
            }
        }
        awardsGivenByHeadDTO.setEmpAwardWinnersUnderHeadDTOS(empAwardWinnersUnderHeadDTOS);
        return awardsGivenByHeadDTO;
    }
}

