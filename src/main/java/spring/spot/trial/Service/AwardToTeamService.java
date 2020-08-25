package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.AwardToTeam;
import spring.spot.trial.Exception.NotFoundException;
import spring.spot.trial.Repository.AwardToTeamRepository;

import java.util.List;

@Service
public class AwardToTeamService {
    @Autowired
    AwardToTeamRepository awardToTeamRepository;

    public AwardToTeamService(AwardToTeamRepository awardToTeamRepository) {
        this.awardToTeamRepository = awardToTeamRepository;
    }

    public AwardToTeam createAwards(AwardToTeam awardToTeam) {
        return awardToTeamRepository.save(awardToTeam);
    }

    public List<AwardToTeam> getAllAwards() {
        List<AwardToTeam> awardToTeam = awardToTeamRepository.findAll();
        if(awardToTeam.isEmpty())
            throw new NotFoundException("Not found!!");
        return awardToTeam;
    }

    public List<AwardToTeam> getAwardsByDepartment(String dept) {
        List<AwardToTeam> awardToTeam = awardToTeamRepository.findByDepartment(dept);
        if(awardToTeam.isEmpty())
            throw new NotFoundException("Award for department "+ dept +" not found");
        return awardToTeam;
    }
    public void deleteAwardsByName(String awardName) {
        awardToTeamRepository.deleteById(awardName);
    }
}
