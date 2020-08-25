package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import spring.spot.trial.Entity.ActivityFeed;
import spring.spot.trial.Repository.ActivityFeedRepository;

import java.util.List;

@Service
public class ActivityService {
    @Autowired
    ActivityFeedRepository activityFeedRepository;

    public ActivityService(ActivityFeedRepository activityFeedRepository) {
        this.activityFeedRepository = activityFeedRepository;
    }


    public List<ActivityFeed> getAll()
    {
        return activityFeedRepository.findAll();
    }
}
