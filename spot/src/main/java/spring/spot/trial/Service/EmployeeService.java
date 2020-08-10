package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.Employee;
import spring.spot.trial.Entity.Team;
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
        return employeeRepository.findAll();
    }

    public List<Employee> getEmployeeById(String id) {
        List<Employee> employees = employeeRepository.findByEmpId(id);
        if (employees.isEmpty())
            throw new NotFoundException("No employee found for id: "+id);
        return employees;
    }


    public Employee updateEmployeeById(String id, Employee emp){
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
                //validation
                employees.add(employeeRepository.findByEmpId(ids).get(0));
            }
            teamDTO.setTeamMembers(employees);
            teamsdto.add(teamDTO);
        }
        managerDTO.setTeams(teamsdto);
        return managerDTO;
    }

    /*public ManagersGivenAwardsDTO getAwardMDetails(String id)
    {
        ManagersGivenAwardsDTO managersGivenAwardsDTO = new ManagersGivenAwardsDTO();
        //manager emp details
        managersGivenAwardsDTO.setEmployee(employeeRepository.findByEmpId(id).get(0));
        List<TeamIndividualDetailsDTO> teamIndividualDetailsDTOS = new ArrayList<>();
        List<Team> teams = teamRepository.findByManagerId(id);
        for (Team t : teams)
        {
            TeamIndividualDetailsDTO teamIndividualDetailsDTO = new TeamIndividualDetailsDTO();
           teamIndividualDetailsDTO.setEmployeeId(t.getEmployeeId());
            teamIndividualDetailsDTO.setTeamName(t.getTeamName());
            List<Employee> e = new ArrayList<>();
            List<EmployeeDetailsDTO> employeeDetailsDTOS=new ArrayList<>();  //is to be set to tdo.setEmpdto
                for (Employee employee : e)
                {
                    List<EmployeeAwardsTM> employeeAwards = new ArrayList<>();  //set to empdto
                   EmployeeDetailsDTO employeeDetailsDTO = new EmployeeDetailsDTO();  //add to empdtos
                      String empid = employee.getEmpId();
                    for (EmployeeAwardsTM employeeAward : employeeAwards)
                    {
                     employeeAwards = employeeAwardsTMRepository.findByEmpId(empid);
                     }
                    employeeDetailsDTO.setFirstName(employee.getFirstName());
                    employeeDetailsDTO.setEmpId(employee.getEmpId());
                    employeeDetailsDTO.setLastName(employee.getLastName());
                    employeeDetailsDTO.setEmpId(employee.getEmpEmail());
                    employeeDetailsDTO.setAwards(employeeAwards);
                    employeeDetailsDTOS.add(employeeDetailsDTO);

                    }
                    teamIndividualDetailsDTO.setEmployeeDetailsDTOS(employeeDetailsDTOS);
                    teamIndividualDetailsDTOS.add(teamIndividualDetailsDTO);
        }
        managersGivenAwardsDTO.setTeamIndividualDetailsDTOS(teamIndividualDetailsDTOS);
        return managersGivenAwardsDTO;
    }*/

}
