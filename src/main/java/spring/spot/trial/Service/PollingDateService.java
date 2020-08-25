package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.PollingDate;
import spring.spot.trial.Exception.NotAcceptableException;
import spring.spot.trial.Exception.NotFoundException;
import spring.spot.trial.Repository.PollingDateRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PollingDateService {
    @Autowired
    PollingDateRepository pollingDateRepository;

    public PollingDateService(PollingDateRepository pollingDateRepository) {
        this.pollingDateRepository = pollingDateRepository;
    }
    
    public PollingDate createPollingDate(PollingDate pollingDate) {
        if(pollingDate.getPollStartDate().compareTo(pollingDate.getPollEndDate())==0 || pollingDate.getPollStartDate().compareTo(pollingDate.getPollEndDate())>0)
            throw new NotAcceptableException("Give valid dates");
        return pollingDateRepository.save(pollingDate);
    }

    public List<PollingDate> getAllPolling() {
        List<PollingDate> pollingDates = pollingDateRepository.findAll();
        if(pollingDates.isEmpty())
            throw new NotFoundException("No polling found");
        return pollingDateRepository.findAll();
    }

    public PollingDate getPollingByDates(LocalDateTime start, LocalDateTime end) {
        return pollingDateRepository.findByPollStartDateAndPollEndDate(start,end);
    }
}
