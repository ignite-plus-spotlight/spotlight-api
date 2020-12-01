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
        List<AwardToTeam> awardToTeams = awardToTeamRepository.findAll();
        if(awardToTeams.isEmpty())
            throw new NotFoundException("Not found!!");
        return awardToTeams;
    }

    public AwardToTeam getAwardsByAwardName(String awardName) {
        return awardToTeamRepository.findByAwardName(awardName);
    }

    public void deleteAwardsByName(String awardName) {
        awardToTeamRepository.deleteById(awardName);
    }
}
