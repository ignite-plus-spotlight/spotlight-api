package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.NominationDate;
import spring.spot.trial.Entity.Nominations;
import spring.spot.trial.Entity.Poll;
import spring.spot.trial.Entity.PollingDate;
import spring.spot.trial.Repository.NominationDateRepository;
import spring.spot.trial.Repository.NominationsRepository;
import spring.spot.trial.Repository.PollRepository;
import spring.spot.trial.Repository.PollingDateRepository;

import java.util.Date;
import java.util.List;

@Service
public class NominationsService {

    @Autowired
    NominationsRepository nominationsRepository;

    @Autowired
    PollRepository pollRepository;

    @Autowired
    NominationDateRepository nominationDateRepository;

    @Autowired
    PollingDateRepository pollingDateRepository;

    public NominationsService(NominationsRepository nominationsRepository){
        this.nominationsRepository = nominationsRepository;
    }

    public Nominations createNominations(Nominations nominations){
        return nominationsRepository.save(nominations);
    }

    public List<Nominations> getAllNominations(){
//        List<Nominations> nominations = nominationsRepository.findAll();
        return nominationsRepository.findAll();
    }

    public Nominations getNominationsById(String pollId){
        return (Nominations) nominationsRepository.findByPollId(pollId);
    }

    public List<Nominations> getNominationsByPollIdAndNominationId(String pollId,String nominationId){
        return nominationsRepository.findByPollIdAndNominationId(pollId,nominationId);
    }

    public Poll postIntoMultipleTables(String pollName, String description, Date nomStart, Date nomEnd, Date pollStart, Date pollEnd, String pollId)
    {
        Poll poll = new Poll();
        poll.setPollId(pollId);
        poll.setPollName(pollName);
        poll.setDescription(description);
        pollRepository.save(poll);

        NominationDate nominationDate = new NominationDate();
        nominationDate.setPollId(pollId);
        nominationDate.setNominationStartDate(nomStart);
        nominationDate.setNominationEndDate(nomEnd);
        nominationDateRepository.save(nominationDate);

        PollingDate pollingDate = new PollingDate();
        pollingDate.setPollName(pollName);
        pollingDate.setPollStartDate(pollStart);
        pollingDate.setPollEndDate(pollEnd);
        pollingDateRepository.save(pollingDate);

        return poll;

    }
}
