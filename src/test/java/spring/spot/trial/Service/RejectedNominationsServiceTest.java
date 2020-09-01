package spring.spot.trial.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import spring.spot.trial.Entity.AwardToIndividual;
import spring.spot.trial.Entity.RejectedNominations;
import spring.spot.trial.Repository.AwardToIndividualRepository;
import spring.spot.trial.Repository.RejectedNominationsRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RejectedNominationsServiceTest {
    RejectedNominationsRepository rejectedNominationsRepository =mock(RejectedNominationsRepository.class);

    @InjectMocks
    RejectedNominationsService rejectedNominationsService;
    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void  findRejectedNominations_test(){
        RejectedNominations rejectedNominations = new RejectedNominations();
        rejectedNominations.setDescription("Good job");
        rejectedNominations.setDirectorName("Rithika");
        rejectedNominations.setManagerId("123");
        rejectedNominations.setManagerName("Apeksha");
        rejectedNominations.setNomineeId("123");
        rejectedNominations.setNomineeName("Poojitha");
        rejectedNominations.setRejectedById("123");
        List<RejectedNominations> rejectedNominationsList = new ArrayList<>();
        rejectedNominationsList.add(rejectedNominations);



        when(rejectedNominationsRepository.findAll()).thenReturn(rejectedNominationsList);
        List<RejectedNominations> response=rejectedNominationsService.findRejectedNominations();
        assertNotNull(response);
    }
}