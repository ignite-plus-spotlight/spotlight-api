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

    //universal
    //used to view all the awards won by the employees
    @GetMapping("activityfeed")
    public List<ActivityFeed> getAllActivity()
    {
        return activityService.getAll();
    }


    @PostMapping("likes/{yourId}")
    public ActivityFeed likes(@PathVariable("yourId") String id,@RequestBody ActivityFeed activityFeed){ return activityService.likes(activityFeed,id);}
}