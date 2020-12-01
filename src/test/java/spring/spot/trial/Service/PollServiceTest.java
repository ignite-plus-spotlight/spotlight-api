package spring.spot.trial.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import spring.spot.trial.Entity.Poll;
import spring.spot.trial.Repository.PollRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PollServiceTest {

    PollRepository pollRepository=mock(PollRepository.class);
    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @InjectMocks
    PollService pollService;

    @Test
    public void createPoll(){
        Poll poll=new Poll();
        poll.setDescription("Hardworking");
        poll.setPeriod("yearly");
        poll.setPollId(UUID.randomUUID());
        poll.setPollName("Award 1");


        when(pollRepository.save(any())).thenReturn(poll);
        Poll response = pollService.createPoll(poll);
        assertEquals("yearly",response.getPeriod());
    }

    @Test
    public void getAllPoll(){
        List<Poll> polls = new ArrayList<>();
        Poll poll1 = new Poll();
        poll1.setPollName("Award 1");
        poll1.setPeriod("yearly");
        poll1.setDescription("Hardworking");

        Poll poll2=new Poll();
        poll2.setPollName("Award 2");
        poll2.setDescription("monthly");
        poll2.setPeriod("Innovative");

        polls.add(poll1);
        polls.add(poll2);

        when(pollRepository.findAll()).thenReturn(polls);
        List<Poll> poll=pollService.getAllPoll();
        assertEquals(2,polls.size());
    }

    @Test
    public void getPollbyId(){
        Poll poll =new Poll();
        poll.setPollName("Award 1");
        poll.setPeriod("yearly");
        poll.setDescription("Hardworking");
        UUID value = UUID.randomUUID();
        poll.setPollId(value);

        when(pollRepository.findByPollId(value)).thenReturn(poll);
        Poll response=pollService.getPollbyId(value);
        assertNotNull(response.getPollId());
    }


}
