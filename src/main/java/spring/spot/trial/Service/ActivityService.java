package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public ActivityFeed likes(ActivityFeed activityFeed)
    {
       int count = activityFeed.getLikes();
       count += 1;
       activityFeed.setLikes(count);
       return activityFeedRepository.save(activityFeed);
    }
    public List<ActivityFeed> getAll()
    {
        return activityFeedRepository.findAll();
    }
}
