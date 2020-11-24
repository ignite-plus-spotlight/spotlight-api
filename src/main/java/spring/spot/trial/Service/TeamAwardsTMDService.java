package spring.spot.trial.Service;

import org.apache.commons.collections.list.TransformedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.*;
import spring.spot.trial.Repository.*;
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

    @Autowired
    IndividualTeamAwardsRepository individualTeamAwardsRepository;

    public TeamAwardsTMDService(TeamAwardsTMDRepository teamAwardsTMDRepository) {
        this.teamAwardsTMDRepository = teamAwardsTMDRepository;
    }

    public TeamAwardsTMD createTeamAwards(String awardName, String awardedById, String periodName, int teamId, String teamName, String headId) {
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


        Team t = teamRepository.findByManagerIdAndTeamId(headId,teamId);
        List<String> members = t.getMembers();
        for (String mid: members)
        {
            Date date = new Date();
            IndividualTeamAwards individualTeamAwards = new IndividualTeamAwards();
            individualTeamAwards.setEmpId(mid);
            individualTeamAwards.setTeamId(teamId);
            individualTeamAwards.setTimestamp(date);
            individualTeamAwardsRepository.save(individualTeamAwards);
        }

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

    /*public ManagerDTO display(String id)
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
    }*/

    public ManagerDTO display(String id)
    {
        List<Employee> employee = employeeRepository.findByEmpId(id);
        List<Team> team = teamRepository.findByManagerId(id);
        List<String> teamMembers =  team.get(0).getMembers();
        ManagerDTO managerDTO = new ManagerDTO();
        List<TeamDTO> teamDTOS = new ArrayList<>();
        for(String memberid : teamMembers) {
            TeamDTO teamDTO = new TeamDTO();
            List<Team> teams = teamRepository.findByManagerId(memberid);
            if (!teamRepository.findByManagerId(memberid).isEmpty()) {
                teamDTO.setTeamId(teams.get(0).getTeamId());
                teamDTO.setTeamName(teams.get(0).getTeamName());
                teamDTO.setHeadId((employeeRepository.findByEmpId(teams.get(0).getManagerId())).get(0).getEmpId());
                teamDTO.setHeadName((employeeRepository.findByEmpId(teams.get(0).getManagerId())).get(0).getFirstName());
                List<String> memberids = teams.get(0).getMembers();
                List<Employee> reportee = new ArrayList<>();
                for (String empId : memberids) {
                    reportee.add(employeeRepository.findByEmpId(empId).get(0));
                }
                teamDTO.setTeamMembers(reportee);
                teamDTOS.add(teamDTO);
            }
            managerDTO.setEmployee(employeeRepository.findByEmpId(id).get(0));
            managerDTO.setTeams(teamDTOS);
        }
        return managerDTO;
    }

    public List<TeamAwardsTMD> displayTeamAwards(String empId)
    {
       List<IndividualTeamAwards> i = individualTeamAwardsRepository.findByEmpId(empId);
       List<TeamAwardsTMD> teamAwardsTMDList = new ArrayList<>();
       for(IndividualTeamAwards individualTeamAwards : i)
       {
            int teamId = individualTeamAwards.getTeamId();
            List<TeamAwardsTMD> teamAwardsTMDS = teamAwardsTMDRepository.findByTeamId(teamId);
            for (TeamAwardsTMD x : teamAwardsTMDS)
            {
                teamAwardsTMDList.add(x);
            }
       }
       return teamAwardsTMDList;
    }

}
