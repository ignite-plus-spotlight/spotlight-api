package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.NominationDate;
import spring.spot.trial.Repository.NominationDateRepository;
import spring.spot.trial.Repository.NominationsRepository;

import java.util.Date;
import java.util.List;

@Service
public class NominationDateService {
@Autowired
NominationDateRepository nominationsRepository;

    public NominationDateService(NominationDateRepository nominationsRepository) {
        this.nominationsRepository = nominationsRepository;
    }

    public NominationDate createNominationDate(NominationDate nominationDate) {
        return nominationsRepository.save(nominationDate);
    }

    public List<NominationDate> getAllNominations() {
        return nominationsRepository.findAll();
    }

    public NominationDate getNominationByDates(Date start, Date end) {
        return nominationsRepository.findByNominationStartDate(start,end);
    }

}
