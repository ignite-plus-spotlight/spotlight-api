package spring.spot.trial.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import spring.spot.trial.Entity.AwardToIndividual;
import spring.spot.trial.Repository.AwardToIndividualRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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

    @Test
    public  void getAllAwards(){
        List<AwardToIndividual> awardToIndividuals=new ArrayList<>();
        AwardToIndividual awardToIndividual1=new AwardToIndividual();
        awardToIndividual1.setAwardName("Employee of the month");
        awardToIndividual1.setPoints(100);
        awardToIndividual1.setImgsrc("http:");
        awardToIndividual1.setDescription("Best Performer");

        AwardToIndividual awardToIndividual2=new AwardToIndividual();
        awardToIndividual2.setAwardName("Best Team Player");
        awardToIndividual2.setPoints(200);
        awardToIndividual2.setImgsrc("http:");
        awardToIndividual2.setDescription("Works great as a team");

        AwardToIndividual awardToIndividual3=new AwardToIndividual();
        awardToIndividual3.setAwardName("Best Innovator");
        awardToIndividual3.setPoints(100);
        awardToIndividual3.setImgsrc("http:");
        awardToIndividual3.setDescription("Comes up with great ideas");

        awardToIndividuals.add(awardToIndividual1);
        awardToIndividuals.add(awardToIndividual2);
        awardToIndividuals.add(awardToIndividual3);
        when(awardToIndividualRepository.findAll()).thenReturn(awardToIndividuals);
        List<AwardToIndividual> awardToIndividual=awardToIndividualService.getAllAwards();

        assertEquals(3,awardToIndividual.size());
    }


    @Test
    public void createAwards(){
        AwardToIndividual awardToIndividual=new AwardToIndividual();
        awardToIndividual.setAwardName("Employee of the month");
        awardToIndividual.setPoints(100);
        awardToIndividual.setImgsrc("http:");
        awardToIndividual.setDescription("Best Performer");
        when(awardToIndividualRepository.save(any())).thenReturn(awardToIndividual);
        AwardToIndividual response = awardToIndividualService.createAwards(awardToIndividual);
        assertEquals("Employee of the month",response.getAwardName());
    }

//    @Test
//    public void deleteAwardsByName() {
//        awardToIndividualService.deleteAwardsByName("Employee of the month");
//
//    }

}
