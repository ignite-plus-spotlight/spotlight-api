package spring.spot.trial.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import spring.spot.trial.Entity.NominationsHistory;
import spring.spot.trial.Repository.NominationsHistoryRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NominationsHistoryServiceTest {
    NominationsHistoryRepository nominationsHistoryRepository = mock(NominationsHistoryRepository.class);

    @InjectMocks
    NominationsHistoryService nominationsHistoryService;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createNominationsHistory(){
        NominationsHistory nominationsHistory= new NominationsHistory();

        nominationsHistory.setCreatedDate(LocalDateTime.now());
        nominationsHistory.setDescription("Best performer");
        nominationsHistory.setEmployeeId("100");
        nominationsHistory.setManagerId("222");
        UUID value= UUID.randomUUID();
        nominationsHistory.setNominationId(value);
        nominationsHistory.setPeriod("yearly");
        nominationsHistory.setPollName("Best Performer");

        when(nominationsHistoryRepository.save(any())).thenReturn(nominationsHistory);
        NominationsHistory response = nominationsHistoryService.createNominationsHistory(nominationsHistory);
        assertEquals("Best Performer",response.getPollName());

    }

    @Test
    public void getAllNominationsHistory(){
        List<NominationsHistory> nominationsHistories= new ArrayList<>();

        NominationsHistory nominationsHistory1 = new NominationsHistory();

        nominationsHistory1.setCreatedDate(LocalDateTime.now());
        nominationsHistory1.setDescription("Best performer");
        nominationsHistory1.setEmployeeId("100");
        nominationsHistory1.setManagerId("222");
        UUID value= UUID.randomUUID();
        nominationsHistory1.setNominationId(value);
        nominationsHistory1.setPeriod("yearly");
        nominationsHistory1.setPollName("Best Performer");

        nominationsHistories.add(nominationsHistory1);

        NominationsHistory nominationsHistory2 = new NominationsHistory();

        nominationsHistory2.setCreatedDate(LocalDateTime.now());
        nominationsHistory2.setDescription("Brainic");
        nominationsHistory2.setEmployeeId("200");
        nominationsHistory2.setManagerId("111");
        UUID value2= UUID.randomUUID();
        nominationsHistory2.setNominationId(value2);
        nominationsHistory2.setPeriod("yearly");
        nominationsHistory2.setPollName("Brainiac");

        nominationsHistories.add(nominationsHistory2);

        when(nominationsHistoryRepository.findAll()).thenReturn(nominationsHistories);
        List<NominationsHistory> response = nominationsHistoryService.getAllNominationsHistory();
        assertEquals(2,response.size());
    }

    @Test
    public void getNominationsHistoryByManagerId(){

        List<NominationsHistory> nominationsHistory= new ArrayList<>();

        NominationsHistory nominationsHistory1= new NominationsHistory();

        nominationsHistory1.setCreatedDate(LocalDateTime.now());
        nominationsHistory1.setDescription("Best performer");
        nominationsHistory1.setEmployeeId("100");
        nominationsHistory1.setManagerId("222");
        UUID value= UUID.randomUUID();
        nominationsHistory1.setNominationId(value);
        nominationsHistory1.setPeriod("yearly");
        nominationsHistory1.setPollName("Best Performer");

        nominationsHistory.add(nominationsHistory1);

        when(nominationsHistoryRepository.findByManagerId(nominationsHistory1.getManagerId())).thenReturn(nominationsHistory);
        List<NominationsHistory> response = nominationsHistoryService.getNominationsHistoryByManagerId(nominationsHistory1.getManagerId());
        assertNotNull(response);

    }
}
