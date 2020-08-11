package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.PollingDate;
import spring.spot.trial.Repository.PollingDateRepository;

import java.util.Date;
import java.util.List;

@Service
public class PollingDateService {
    @Autowired
    PollingDateRepository pollingDateRepository;

    public PollingDateService(PollingDateRepository pollingDateRepository) {
        this.pollingDateRepository = pollingDateRepository;
    }
    
    public PollingDate createPollingDate(PollingDate pollingDate) {
        return pollingDateRepository.save(pollingDate);
    }

    public List<PollingDate> getAllPolling() {
        return pollingDateRepository.findAll();
    }

    public PollingDate getPollingByDates(Date start, Date end) {
        return pollingDateRepository.findByPollStartDateAndPollEndDate(start,end);
    }
}
