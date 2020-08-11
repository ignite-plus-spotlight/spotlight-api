package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.Poll;
import spring.spot.trial.Repository.PollRepository;

import java.util.List;

@Service
public class PollService {
    @Autowired
    PollRepository pollRepository;

    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    public Poll createPoll(Poll poll) { return pollRepository.save(poll); }

    public List<Poll> getAllPoll() {
        return pollRepository.findAll();
    }

    public Poll getPollbyId(String pollId) { return pollRepository.findByPollId(pollId); }

    public Poll updateEmpRolesById(Poll poll) {
        return pollRepository.save(poll);
    }

}
