package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.AwardToTeam;
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
        return awardToTeamRepository.findAll();
    }

    public List<AwardToTeam> getAwardsByDepartment(String dept) {
        return awardToTeamRepository.findByDepartment(dept);
    }

    public void deleteAwardsByName(String awardName) {
        awardToTeamRepository.deleteById(awardName);
    }
}
