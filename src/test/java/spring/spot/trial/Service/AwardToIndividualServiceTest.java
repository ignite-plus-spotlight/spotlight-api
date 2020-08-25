package spring.spot.trial.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import spring.spot.trial.Entity.AwardToIndividual;
import spring.spot.trial.Repository.AwardToIndividualRepository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AwardToIndividualServiceTest {
    AwardToIndividualRepository awardToIndividualRepository=mock(AwardToIndividualRepository.class);

   @InjectMocks
    AwardToIndividualService awardToIndividualService;
    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void  getAwardsByAwardName_test(){
       AwardToIndividual awardToIndividual = new AwardToIndividual();
       awardToIndividual.setAwardName("Employee of the month");
       awardToIndividual.setDescription("Best Performer");
       awardToIndividual.setImgsrc("http:");
       awardToIndividual.setPoints(100);

       when(awardToIndividualRepository.findByAwardName("Employee of the month")).thenReturn(awardToIndividual);
       AwardToIndividual response=awardToIndividualService.getAwardsByAwardName("Employee of the month");
       assertEquals("Best Performer",response.getDescription());
    }



}
