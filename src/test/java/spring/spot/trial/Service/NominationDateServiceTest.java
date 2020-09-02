package spring.spot.trial.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import spring.spot.trial.Entity.NominationDate;
import spring.spot.trial.Repository.NominationDateRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NominationDateServiceTest {

    NominationDateRepository nominationDateRepository = mock(NominationDateRepository.class);

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @InjectMocks
    NominationDateService nominationDateService;

    @Test
    public void createNominationDate() {

        NominationDate nominationDate = new NominationDate();
        nominationDate.setPollId(UUID.randomUUID());
        nominationDate.setNominationStartDate(LocalDateTime.now());
        nominationDate.setNominationEndDate(LocalDateTime.of(2020, 12, 28, 6, 05, 04));

        when(nominationDateRepository.save(any())).thenReturn(nominationDate);
        NominationDate response = nominationDateService.createNominationDate(nominationDate);
        assertNotNull(response);
    }

    @Test
    public void getAllNominations() {
        List<NominationDate> nominationDateList = new ArrayList<>();

        NominationDate nominationDate1 = new NominationDate();
        nominationDate1.setPollId(UUID.randomUUID());
        nominationDate1.setNominationStartDate(LocalDateTime.now());
        nominationDate1.setNominationEndDate(LocalDateTime.of(2020, 12, 28, 6, 05, 04));

        NominationDate nominationDate2 = new NominationDate();
        nominationDate2.setPollId(UUID.randomUUID());
        nominationDate2.setNominationStartDate(LocalDateTime.now());
        nominationDate2.setNominationEndDate(LocalDateTime.of(2020, 11, 28, 6, 05, 04));

        nominationDateList.add(nominationDate1);
        nominationDateList.add(nominationDate2);

        when(nominationDateRepository.findAll()).thenReturn(nominationDateList);
        List<NominationDate> nominationDates = nominationDateService.getAllNominations();
        assertNotNull(nominationDates);
    }
}
