package spring.spot.trial.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import spring.spot.trial.Entity.ActivityFeed;
import spring.spot.trial.Repository.ActivityFeedRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ActivityServiceTest {

    ActivityFeedRepository activityFeedRepository = mock(ActivityFeedRepository.class);

    @BeforeEach
    public void beforeEach(){
        MockitoAnnotations.initMocks(this);
    }

    @InjectMocks
    ActivityService activityService;

    @Test
    public void getAll(){
        List<ActivityFeed> activity = new ArrayList<>();

        ActivityFeed activity1 = new ActivityFeed();
        activity1.setAwardeeId("111");
        activity1.setUuid(UUID.randomUUID());
        activity1.setAwardeeName("Ayan");
        activity1.setAwardName("Employee Of The Year");
        activity1.setDescription("Best Performer");
        activity1.setImgsrc("http:");
        activity1.setLikes(2);
        activity1.setPoints(200);

        ActivityFeed activity2 = new ActivityFeed();
        activity2.setAwardeeId("222");
        activity2.setUuid(UUID.randomUUID());
        activity2.setAwardeeName("Aman");
        activity2.setAwardName("Employee Of The Quarter");
        activity2.setDescription("Best Performer");
        activity2.setImgsrc("http:");
        activity2.setLikes(3);
        activity2.setPoints(200);

        activity.add(activity1);
        activity.add(activity2);

        when(activityFeedRepository.findAll()).thenReturn(activity);
        List<ActivityFeed> activities = activityService.getAll();
        assertEquals(2,activities.size());

    }


}