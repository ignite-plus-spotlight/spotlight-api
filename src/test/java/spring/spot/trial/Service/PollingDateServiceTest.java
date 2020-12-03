package spring.spot.trial.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import spring.spot.trial.Entity.PollingDate;
import spring.spot.trial.Repository.PollingDateRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PollingDateServiceTest {
    PollingDateRepository pollingDateRepository=mock(PollingDateRepository.class);

    @InjectMocks
     PollingDateService pollingDateService;

    @BeforeEach
    public void beforeEach(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createPollingDate()
    {
        PollingDate pollingDate = new PollingDate();
        UUID value= UUID.randomUUID();
        pollingDate.setPollId(value);
        pollingDate.setPollName("Techie");
        pollingDate.setPollStartDate(LocalDateTime.now());
        pollingDate.setPollEndDate(LocalDateTime.of(2020,12,28,6,05,04));

        when(pollingDateRepository.save(any())).thenReturn(pollingDate);
        PollingDate response = pollingDateService.createPollingDate(pollingDate);
        assertEquals("Techie",response.getPollName());
    }

    @Test
    public  void getAllPolling(){
        List<PollingDate> pollingDates= new ArrayList<>();
        PollingDate pollingDate1 = new PollingDate();
        UUID value1= UUID.randomUUID();
        pollingDate1.setPollId(value1);
        pollingDate1.setPollName("Techie");
        pollingDate1.setPollStartDate(LocalDateTime.now());
        pollingDate1.setPollEndDate(LocalDateTime.of(2020,12,28,6,05,04));

        PollingDate pollingDate2 = new PollingDate();
        UUID value2= UUID.randomUUID();
        pollingDate2.setPollId(value2);
        pollingDate2.setPollName("Innovator");
        pollingDate2.setPollStartDate(LocalDateTime.now());
        pollingDate2.setPollEndDate(LocalDateTime.of(2020,12,28,6,05,04));

        pollingDates.add(pollingDate1);
        pollingDates.add(pollingDate2);

        when(pollingDateRepository.findAll()).thenReturn(pollingDates);
        List<PollingDate> response = pollingDateService.getAllPolling();
        assertEquals(2,response.size());

    }

    @Test
    public void getPollingByDates()
    {
        PollingDate pollingDate = new PollingDate();
        UUID value= UUID.randomUUID();
        pollingDate.setPollId(value);
        pollingDate.setPollName("Techie");
        LocalDateTime start = LocalDateTime.now();
        pollingDate.setPollStartDate(start);
        LocalDateTime end = LocalDateTime.of(2020,12,28,6,05,04);
        pollingDate.setPollEndDate(end);

        when(pollingDateRepository.findByPollStartDateAndPollEndDate(start,end)).thenReturn(pollingDate);
        PollingDate response = pollingDateService.getPollingByDates(start,end);
        assertEquals("Techie",response.getPollName());
    }

}
