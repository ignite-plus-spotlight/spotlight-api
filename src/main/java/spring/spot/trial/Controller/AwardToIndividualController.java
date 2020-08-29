package spring.spot.trial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.AwardToIndividual;
import spring.spot.trial.Service.AwardToIndividualService;

import java.util.List;

/*Give away an award to individual*/

@CrossOrigin("*")
@RestController
@RequestMapping
public class AwardToIndividualController {

    @Autowired
    private AwardToIndividualService awardToIndividualService;

    public AwardToIndividualController(AwardToIndividualService awardToIndividualService) {
        this.awardToIndividualService = awardToIndividualService;
    }

    //used in "reward" tab to display all the available awards
    @GetMapping("/employee/individualawards")
    public List<AwardToIndividual> getAllAwards() {
        return (List<AwardToIndividual>) awardToIndividualService.getAllAwards();
    }

    @GetMapping(value = "/employee/{name}/individualawards")
    public AwardToIndividual getAwardsByAwardName(@PathVariable("name") String awardName) {
        return awardToIndividualService.getAwardsByAwardName(awardName);
    }

    //admin privilege to create new awards
    @PostMapping("/employee/individualawards")
    public AwardToIndividual createAwards(@RequestBody AwardToIndividual awardToIndividual) {
        return awardToIndividualService.createAwards(awardToIndividual);
    }

    @DeleteMapping(value = "/employee/{name}/individualawards")
    public String deleteAwardsByName(@PathVariable("name") String awardName) {
        awardToIndividualService.deleteAwardsByName(awardName);
        return "Award with name " + awardName + " has been deleted!";
    }
}

