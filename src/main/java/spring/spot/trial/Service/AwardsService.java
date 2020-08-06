package spring.spot.trial.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.Awards;
import spring.spot.trial.Repository.AwardsRepository;
import java.util.List;

@Service
public class AwardsService {

    @Autowired
    private AwardsRepository awardsRepository;

    public AwardsService(AwardsRepository rolesRepository) {
        this.awardsRepository = rolesRepository;
    }


    public Awards createAwards(Awards awards) {
        return awardsRepository.save(awards);
    }


    public List<Awards> getAllAwards() {
        return awardsRepository.findAll();
    }

    public List<Awards> getAwardsByAwardName(String awardName) {
        return awardsRepository.findByAwardName(awardName);
    }

    public void deleteAwardsByName(String awardName) {
        awardsRepository.deleteById(awardName);
    }
}
