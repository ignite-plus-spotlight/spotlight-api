package spring.spot.trial.Service;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import spring.spot.trial.Entity.*;
import spring.spot.trial.Repository.NominationDateRepository;
import spring.spot.trial.Repository.NominationsRepository;
import spring.spot.trial.Repository.PollRepository;
import spring.spot.trial.Repository.PollingDateRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NominationServiceTest {
    NominationsRepository nominationsRepository = mock(NominationsRepository.class);
    NominationDateRepository nominationDateRepository = mock(NominationDateRepository.class);
    PollRepository pollRepository = mock(PollRepository.class);
    PollingDateRepository pollingDateRepository = mock(PollingDateRepository.class);

    @InjectMocks
    NominationsService nominationsService;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createNominations_test()
    {
        Nominations nominations = new Nominations();
        nominations.setDescription("Meets all requirements");
        nominations.setEmployeeId("123");
        nominations.setManagerId("234");
        nominations.setNominationId(UUID.randomUUID());
        nominations.setPeriod("quarterly");
        nominations.setPollId(UUID.randomUUID());

        when(nominationsRepository.save(any())).thenReturn(nominations);
        Nominations response = nominationsService.createNominations(nominations);
        assertNotNull(response);
    }

    @Test
    public void getAllNomination_test()
    {
        Nominations nominations = new Nominations();
        nominations.setDescription("Meets all requirements");
        nominations.setEmployeeId("123");
        nominations.setManagerId("234");
        nominations.setNominationId(UUID.randomUUID());
        nominations.setPeriod("quarterly");
        nominations.setPollId(UUID.randomUUID());
        List<Nominations> nominationsList = new ArrayList<>();
        nominationsList.add(nominations);

        when(nominationsRepository.findAll()).thenReturn(nominationsList);
        List<Nominations> response = nominationsService.getAllNominations();
        assertNotNull(response);
    }


    @Test
    public void postIntoMultipleEntity_test()
    {
        PostIntoMultipleEntity postIntoMultipleEntity = new PostIntoMultipleEntity();
        postIntoMultipleEntity.setDescription("For the best ui");
        postIntoMultipleEntity.setPeriod("yearly");
        postIntoMultipleEntity.setPollName("Best ui of the year");

        Poll poll = new Poll();
        poll.setDescription("For the best ui");
        poll.setPeriod("yearly");
        poll.setPollId(UUID.randomUUID());
        poll.setPollName("Best ui of the year");

        NominationDate nominationDate = new NominationDate();
        nominationDate.setNominationEndDate(LocalDateTime.now());
        nominationDate.setNominationStartDate(LocalDateTime.now());
        nominationDate.setPollId(UUID.randomUUID());

        PollingDate pollingDate = new PollingDate();
        pollingDate.setPollEndDate(LocalDateTime.now());
        pollingDate.setPollId(UUID.randomUUID());
        pollingDate.setPollName("Best ui of the year");
        pollingDate.setPollStartDate(LocalDateTime.now());

        when(nominationDateRepository.save(any())).thenReturn(nominationDate);
        when(pollRepository.save(any())).thenReturn(poll);
        when(pollingDateRepository.save(any())).thenReturn(pollingDate);

        PostIntoMultipleEntity response = nominationsService.postIntoMultipleTables(postIntoMultipleEntity);
        assertNotNull(response);

    }
}
