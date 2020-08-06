package spring.spot.trial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.Awards;
import spring.spot.trial.Service.AwardsService;


import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping
public class AwardsController {

    @Autowired
    private AwardsService awardsService;

    public AwardsController(AwardsService awardsService) {
        this.awardsService = awardsService;
    }

    @GetMapping("/awards")
    public List<Awards> getAllAwards() {
        return (List<Awards>) awardsService.getAllAwards();
    }

    @GetMapping(value = "/awards/{name}")
    public List<Awards> getAwardsByAwardName(@PathVariable("name") String awardName) { return awardsService.getAwardsByAwardName(awardName); }


    @PostMapping("/awards")
    public Awards createAwards(@RequestBody Awards awards) { return awardsService.createAwards(awards); }

    @DeleteMapping(value = "/awards/{name}")
    public String deleteAwardsByName(@PathVariable("name") String awardName) {
        awardsService.deleteAwardsByName(awardName);
        return "Award with name " + awardName + " has been deleted!";
    }
}