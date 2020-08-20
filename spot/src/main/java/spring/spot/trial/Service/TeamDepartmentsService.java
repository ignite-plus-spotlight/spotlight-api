package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.TeamDepartments;
import spring.spot.trial.Exception.NotFoundException;
import spring.spot.trial.Repository.TeamDepartmentsRepository;

import java.util.List;

@Service
public class TeamDepartmentsService {
    @Autowired
    TeamDepartmentsRepository teamDepartmentsRepository;

    public TeamDepartmentsService(TeamDepartmentsRepository teamDepartmentsRepository) {
        this.teamDepartmentsRepository = teamDepartmentsRepository;
    }

    public TeamDepartments createTeamDepartments(TeamDepartments teamDepartments){
        return teamDepartmentsRepository.save(teamDepartments);
    }

    public List<TeamDepartments> getAllTeamDepartments(){
        List<TeamDepartments> teamDepartments = teamDepartmentsRepository.findAll();
        if(teamDepartments.isEmpty())
            throw new NotFoundException("No departments");
        return teamDepartments;
    }

    public List<TeamDepartments> getTeamDepartmentsByName(String dept){
        List<TeamDepartments> teamDepartments = teamDepartmentsRepository.findByDepartment(dept);
        if(teamDepartments.isEmpty())
            throw new NotFoundException("No department with name "+dept+" found");
        return teamDepartments;
    }

    public TeamDepartments updateTeamDepartmentsByName(String name, TeamDepartments dept) {
        List<TeamDepartments> teamDepartments = teamDepartmentsRepository.findByDepartment(name);
        if(teamDepartments.isEmpty())
            throw new NotFoundException("No department with name "+name+" found");
        return teamDepartmentsRepository.save(dept);
    }
}
