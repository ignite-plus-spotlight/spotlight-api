package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.IndividualTeamAwards;


import spring.spot.trial.Repository.IndividualTeamAwardsRepository;

@Service
public class IndividualTeamAwardsService {
    @Autowired
    IndividualTeamAwardsRepository individualTeamAwardsRepository;
    public IndividualTeamAwardsService(IndividualTeamAwardsRepository individualTeamAwardsRepository)
    {
        this.individualTeamAwardsRepository=individualTeamAwardsRepository;
    }

    public IndividualTeamAwards createRoles(IndividualTeamAwards individualTeamAwards) {
        return individualTeamAwardsRepository.save(individualTeamAwards);
    }


}
