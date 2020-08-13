package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.Poll;
import spring.spot.trial.Exception.NotFoundException;
import spring.spot.trial.Repository.PollRepository;

import java.util.List;
import java.util.UUID;

@Service
public class PollService {
    @Autowired
    PollRepository pollRepository;

    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    public Poll createPoll(Poll poll) { return pollRepository.save(poll); }

    public List<Poll> getAllPoll() {
        List<Poll> polls = pollRepository.findAll();
        if(polls.isEmpty())
            throw new NotFoundException("No Polls found!");
        return polls;
    }

    public Poll getPollbyId(UUID pollId) {
        Poll poll = pollRepository.findByPollId(pollId);
        if(poll == null)
            throw new NotFoundException("No poll with id "+pollId+" found!");
        return poll;
    }
    public Poll updateEmpRolesById(Poll poll) {
        return pollRepository.save(poll);
    }

}
