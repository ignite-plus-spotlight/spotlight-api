package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.Employee;
import spring.spot.trial.Entity.Team;
import spring.spot.trial.Exception.InputValidationException;
import spring.spot.trial.Exception.NotFoundException;
import spring.spot.trial.Repository.EmployeeAwardsTMRepository;
import spring.spot.trial.Repository.EmployeeRepository;
import spring.spot.trial.Repository.TeamRepository;
import spring.spot.trial.dto.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private EmployeeAwardsTMRepository employeeAwardsTMRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public Employee createEmployee(Employee emp) {
        String id = emp.getEmpId();
        List<Employee> employee = employeeRepository.findByEmpId(id);
        if (employee.isEmpty())
            return employeeRepository.save(emp);
        else
            return employee.get(0);
    }

    public List<Employee> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        if(employees.isEmpty())
            throw new InputValidationException("Not found!!");
        return employees;
    }

    public List<Employee> getEmployeeById(String id) {
        //InputValidationException.validateInputParameter(id);
        List<Employee> employees = employeeRepository.findByEmpId(id);
        if (employees.isEmpty())
            throw new NotFoundException("No employee found for id: "+id);
        return employees;
    }


    public Employee updateEmployeeById(String id, Employee emp){
        InputValidationException.validateInputParameter(id);
        List<Employee> employees = employeeRepository.findByEmpId(id);
        if (employees.isEmpty())
            throw new NotFoundException("No employee found for id: "+id);
        return employeeRepository.save(emp);
    }

    public Employee findByIdAndFirstName(String id, String firstName) {
        InputValidationException.validateInputParameter(id);
        Employee employees = employeeRepository.findByEmpIdAndFirstName(id,firstName);
        if (employees == null)
            throw new NotFoundException("No employee for : "+id+" and first name "+firstName+" found");
        return employees;
    }



    public ManagerDTO getManagerDetails(String id) {
        ManagerDTO managerDTO = new ManagerDTO();
        //Manager Employee Information
        managerDTO.setEmployee(employeeRepository.findByEmpId(id).get(0));

        // Manager can have list of Teams

        // Database Team Entity Way
        List<Team> teams = teamRepository.findByManagerId(id);

        // Team DTO initialize
        List<TeamDTO> teamsdto = new ArrayList<>();
        for (Team team: teams){
            TeamDTO teamDTO = new TeamDTO();
            teamDTO.setTeamId(team.getTeamId());
            teamDTO.setTeamName(team.getTeamName());
            //validate not null
            List<Employee> employees = new ArrayList<>();
            for (String ids: team.getMembers()){
                //validation
                employees.add(employeeRepository.findByEmpId(ids).get(0));
            }
            teamDTO.setTeamMembers(employees);
            teamsdto.add(teamDTO);
        }
        managerDTO.setTeams(teamsdto);
        return managerDTO;
    }

    //details of all the employees down the hierarchy
    public List<HierarchyDTO> levels(String headId)
    {
        HierarchyDTO hierarchy = new HierarchyDTO();
        hierarchy.setValue(employeeRepository.findByEmpId(headId).get(0));
        List<Team> teams = teamRepository.findByManagerId(headId);
        List<HierarchyDTO> children = new ArrayList<>();
        if(teams.isEmpty())
        {
            return null;
        }
        for (Team team : teams)
        {
           for (String id : team.getMembers())
           {
               HierarchyDTO h = new HierarchyDTO();
               h.setValue(employeeRepository.findByEmpId(id).get(0));
               h.setChildren(levels(id));
               children.add(h);
           }
        }
        hierarchy.setChildren(children);
        return children;
    }
}
