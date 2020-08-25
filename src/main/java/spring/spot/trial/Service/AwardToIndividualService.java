package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.AwardToIndividual;
import spring.spot.trial.Exception.NotFoundException;
import spring.spot.trial.Repository.AwardToIndividualRepository;

import java.util.List;

@Service
public class AwardToIndividualService {

//    @Autowired

    private AwardToIndividualRepository awardToIndividualRepository;

    @Autowired
    public AwardToIndividualService(AwardToIndividualRepository awardToIndividualRepository) {
        this.awardToIndividualRepository = awardToIndividualRepository;
    }


    public AwardToIndividual createAwards(AwardToIndividual awardToIndividual) {
        return awardToIndividualRepository.save(awardToIndividual);
    }


    public List<AwardToIndividual> getAllAwards() {
        List<AwardToIndividual> awardToIndividuals = awardToIndividualRepository.findAll();
        if(awardToIndividuals.isEmpty())
            throw new NotFoundException("Not found!!");
        return awardToIndividuals;
    }

    public AwardToIndividual getAwardsByAwardName(String awardName) {
        AwardToIndividual awardToIndividuals = awardToIndividualRepository.findByAwardName(awardName);
        if(awardToIndividuals == null)
            throw new NotFoundException("Award with name "+awardName+" not found");
        return awardToIndividuals;
    }

    public void deleteAwardsByName(String awardName) {
        awardToIndividualRepository.deleteById(awardName);
    }
}
