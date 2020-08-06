package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.Employee;
import spring.spot.trial.Entity.Team;
import spring.spot.trial.Entity.TeamDepartments;
import spring.spot.trial.Repository.EmployeeRepository;
import spring.spot.trial.Repository.TeamRepository;
import spring.spot.trial.dto.ManagerDTO;
import spring.spot.trial.dto.TeamDTO;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TeamRepository teamRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public Employee createEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }


    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public List<Employee> getEmployeeById(String id) {
        return employeeRepository.findByEmpId(id);
    }


    public Employee updateEmployeeById(String id, Employee emp) {
        return employeeRepository.save(emp);
    }


    public Employee findByKeyFirstName(String id, String firstName) {
        return employeeRepository.findByEmpIdAndFirstName(id, firstName);
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
                //validattion
                employees.add(employeeRepository.findByEmpId(ids).get(0));
            }
            teamDTO.setTeamMembers(employees);
            teamsdto.add(teamDTO);
        }
        managerDTO.setTeams(teamsdto);
        return managerDTO;
    }
}