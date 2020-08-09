package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.TeamDepartments;
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
        return teamDepartmentsRepository.findAll();
    }

    public List<TeamDepartments> getTeamDepartmentsByName(String dept){
        return teamDepartmentsRepository.findByDepartment(dept);
    }

    public TeamDepartments updateTeamDepartmentsByName(String name, TeamDepartments dept) {
        return teamDepartmentsRepository.save(dept);
    }
}
