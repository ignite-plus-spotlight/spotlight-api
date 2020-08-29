package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.ActivityFeed;
import spring.spot.trial.Entity.EmpLikes;
import spring.spot.trial.Repository.ActivityFeedRepository;
import spring.spot.trial.Repository.EmployeeLikesRepository;

import java.util.List;

@Service
public class ActivityService {
    @Autowired
    ActivityFeedRepository activityFeedRepository;
    @Autowired
    EmployeeLikesRepository employeeLikesRepository;

    public ActivityService(ActivityFeedRepository activityFeedRepository) {
        this.activityFeedRepository = activityFeedRepository;
    }

    public ActivityFeed likes(ActivityFeed activityFeed, String yourId)
    {
        EmpLikes empLikes = new EmpLikes();
        empLikes.setAwardeeId(activityFeed.getAwardeeId());
        empLikes.setEmpId(yourId);
        empLikes.setUuid(activityFeed.getUuid());

        int count = activityFeed.getLikes();
        if(employeeLikesRepository.findByAwardeeIdAndUuidAndEmpId(activityFeed.getAwardeeId(),activityFeed.getUuid(),yourId)==null) {
            count += 1;
            employeeLikesRepository.save(empLikes);
        }
        activityFeed.setLikes(count);
        return activityFeedRepository.save(activityFeed);

    }
    public List<ActivityFeed> getAll()
    {
        return activityFeedRepository.findAll();
    }
}