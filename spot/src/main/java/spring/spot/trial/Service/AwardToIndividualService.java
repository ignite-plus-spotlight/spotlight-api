package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.AwardToIndividual;
import spring.spot.trial.Repository.AwardToIndividualRepository;

import java.util.List;

@Service
public class AwardToIndividualService {

    @Autowired
    private AwardToIndividualRepository awardToIndividualRepository;

    public AwardToIndividualService(AwardToIndividualRepository awardToIndividualRepository) {
        this.awardToIndividualRepository = awardToIndividualRepository;
    }


    public AwardToIndividual createAwards(AwardToIndividual awardToIndividual) {
        return awardToIndividualRepository.save(awardToIndividual);
    }


    public List<AwardToIndividual> getAllAwards() {
        return awardToIndividualRepository.findAll();
    }

    public AwardToIndividual getAwardsByAwardName(String awardName) {
        return awardToIndividualRepository.findByAwardName(awardName);
    }

    public void deleteAwardsByName(String awardName) {
        awardToIndividualRepository.deleteById(awardName);
    }
}
