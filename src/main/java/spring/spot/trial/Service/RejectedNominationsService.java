package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.RejectedNominations;
import spring.spot.trial.Repository.RejectedNominationsRepository;

import java.util.List;

@Service
public class RejectedNominationsService {

    @Autowired
    RejectedNominationsRepository rejectedNominationsRepository;

    public RejectedNominationsService(RejectedNominationsRepository rejectedNominationsRepository){
        this.rejectedNominationsRepository = rejectedNominationsRepository;
    }

    public List<RejectedNominations> findRejectedNominations(){
        return rejectedNominationsRepository.findAll();
    }

    public RejectedNominations createReject(RejectedNominations rejectedNominations){
        return rejectedNominationsRepository.save(rejectedNominations);
    }

    public List<RejectedNominations> findById(String rejectedById){
        return rejectedNominationsRepository.findByRejectedById(rejectedById);
    }

}