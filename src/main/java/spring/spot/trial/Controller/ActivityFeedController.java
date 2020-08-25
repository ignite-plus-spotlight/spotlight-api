package spring.spot.trial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.ActivityFeed;
import spring.spot.trial.Service.ActivityService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping
@ResponseBody
public class ActivityFeedController {
    @Autowired
    ActivityService activityService;

    public ActivityFeedController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("activityfeed")
    public List<ActivityFeed> getAllActivity()
    {
        return activityService.getAll();
    }
}
