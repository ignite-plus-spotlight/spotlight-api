package spring.spot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.Entity.Employee;
import spring.spot.Entity.Nominations;
import spring.spot.Exception.NominationsException;
import spring.spot.Repository.NominationsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NominationsService {

    @Autowired
    private NominationsRepository nominationsRepository;

    public NominationsService(NominationsRepository nominationsRepository) {
        this.nominationsRepository =nominationsRepository;
    }


    public Nominations createNominations(Nominations nominee) {
        return nominationsRepository.save(nominee);
    }


    public List<Nominations> getAllNominations() {
        return nominationsRepository.findAll();
    }

    public List<Nominations> getNominationsById(int id) {

        return nominationsRepository.findByNominationsKeyNominee(id);
    }

    public Nominations findByKeyPeriodName(int id, String periodName) {
        return nominationsRepository.findByNominationsKeyNomineeAndNominationsKeyPeriodName(id, periodName);
    }

    public Nominations updateNominationsById(int id, Nominations nominations) {
        return nominationsRepository.save(nominations);
    }


}
