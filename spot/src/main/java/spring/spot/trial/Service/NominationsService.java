package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.Nominations;
import spring.spot.trial.Repository.NominationsRepository;

import java.util.List;

@Service
public class NominationsService {

    @Autowired
    NominationsRepository nominationsRepository;

    public NominationsService(NominationsRepository nominationsRepository){
        this.nominationsRepository = nominationsRepository;
    }

    public Nominations createNominations(Nominations nominations){
        return nominationsRepository.save(nominations);
    }

    public List<Nominations> getAllNominations(){
//        List<Nominations> nominations = nominationsRepository.findAll();
        return (List<Nominations>) nominationsRepository.findAll();
    }

    public Nominations getNominationsById(String pollId){
        return (Nominations) nominationsRepository.findByPollId(pollId);
    }

    public List<Nominations> getNominationsByPollIdAndNominationId(String pollId,String nominationId){
        return (List<Nominations>) nominationsRepository.findByPollIdAndNominationId(pollId,nominationId);
    }



}
