package spring.spot.trial.Service;

import org.apache.commons.collections.list.TransformedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.AwardToTeam;
import spring.spot.trial.Entity.Employee;
import spring.spot.trial.Entity.Team;
import spring.spot.trial.Entity.TeamAwardsTMD;
import spring.spot.trial.Repository.AwardToTeamRepository;
import spring.spot.trial.Repository.EmployeeRepository;
import spring.spot.trial.Repository.TeamAwardsTMDRepository;
import spring.spot.trial.Repository.TeamRepository;
import spring.spot.trial.dto.ManagerDTO;
import spring.spot.trial.dto.TeamDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TeamAwardsTMDService {
    @Autowired
    TeamAwardsTMDRepository teamAwardsTMDRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    AwardToTeamRepository awardToTeamRepository;

    public TeamAwardsTMDService(TeamAwardsTMDRepository teamAwardsTMDRepository) {
        this.teamAwardsTMDRepository = teamAwardsTMDRepository;
    }

    public TeamAwardsTMD createTeamAwards(String awardName, String awardedById, String periodName, int teamId, String teamName) {
        Date d = new Date();
        TeamAwardsTMD team = new TeamAwardsTMD();
        AwardToTeam awardToTeam = awardToTeamRepository.findByAwardName(awardName);

        String description = awardToTeam.getDescription();
        String imgsrc = awardToTeam.getImgsrc();
        int teamPoints = awardToTeam.getPoints();

        team.setAwardName(awardName);
        team.setDescription(description);
        team.setImgsrc(imgsrc);
        team.setAwardedById(awardedById);
        team.setPeriodName(periodName);
        team.setTeamId(teamId);
        team.setTeamName(teamName);
        team.setTeamPoints(teamPoints);
        team.setTimestamp(d);
        return teamAwardsTMDRepository.save(team);
    }

    public List<TeamAwardsTMD> getAllTeamAwards() {
        return teamAwardsTMDRepository.findAll();
    }

    public List<TeamAwardsTMD> getTeamAwardsById(int id) {
        return teamAwardsTMDRepository.findByTeamId(id);
    }

    public TeamAwardsTMD updateTeamAwardsById(int id, TeamAwardsTMD teamAwardsTMD) {
        return teamAwardsTMDRepository.save(teamAwardsTMD);
    }

    public ManagerDTO display(String id)
    {
        List<Employee> employee = employeeRepository.findByEmpId(id);
        List<Team> team = teamRepository.findByManagerId(id);
        List<String> teamMembers =  team.get(0).getMembers();
        ManagerDTO managerDTO = new ManagerDTO();
        List<TeamDTO> teamDTOS = new ArrayList<>();
        for(String memberid : teamMembers)
        {
            TeamDTO teamDTO = new TeamDTO();
            List<Team> teams = teamRepository.findByManagerId(memberid);
            teamDTO.setTeamId(teams.get(0).getTeamId());
            teamDTO.setTeamName(teams.get(0).getTeamName());
            teamDTO.setHeadName((employeeRepository.findByEmpId(teams.get(0).getManagerId())).get(0).getFirstName());
           List<String> memberids =  teams.get(0).getMembers();
           List<Employee> reportee = new ArrayList<>();
           for (String empId : memberids) {
               reportee.add(employeeRepository.findByEmpId(empId).get(0));
           }
            teamDTO.setTeamMembers(reportee);
           teamDTOS.add(teamDTO);
        }
       managerDTO.setEmployee(employeeRepository.findByEmpId(id).get(0));
        managerDTO.setTeams(teamDTOS);
        return managerDTO;
    }

}
