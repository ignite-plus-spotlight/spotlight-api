package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.Nominations;
import spring.spot.trial.Exception.EmployeeException;
import spring.spot.trial.Repository.NominationsRepository;

import java.util.List;
@Service
public class NominationsService {

    @Autowired
    NominationsRepository nominationsRepository;

    public NominationsService(NominationsRepository nominationsRepository) {
        this.nominationsRepository = nominationsRepository;
    }

    public Nominations createNominations(Nominations nominations) {
        return nominationsRepository.save(nominations);
    }

    public List<Nominations> getAllNominations() {
        return nominationsRepository.findAll();
    }

    public List<Nominations> getNominationsByManagerId(String manager_id) {
        return nominationsRepository.findByManagerId(manager_id);
    }

    public Nominations updateNominationsById(String id, Nominations nominations) {
        return nominationsRepository.save(nominations);
    }

}


