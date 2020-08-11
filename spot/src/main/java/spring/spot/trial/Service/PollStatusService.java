package spring.spot.trial.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.PollStatus;
import spring.spot.trial.Repository.PollStatusRepository;

import java.util.List;

@Service
public class PollStatusService {
    @Autowired
    PollStatusRepository pollStatusRepository;

    public PollStatusService(PollStatusRepository pollStatusRepository) {
        this.pollStatusRepository = pollStatusRepository;
    }

    public List<PollStatus> getAllPollStatus(){
        return (List<PollStatus>) pollStatusRepository.findAll();
    }

    public List<PollStatus> getAllByPollId(String id){
        return (List<PollStatus>) pollStatusRepository.findByPollId(id);
    }

    public List<PollStatus> getAllByPollIdAndNominationId(String id,String nominationId){
        return (List<PollStatus>) pollStatusRepository.findByPollIdAndNominationId(id,nominationId);
    }
}
