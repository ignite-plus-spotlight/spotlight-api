package spring.spot.trial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.CategoryTeams;
import spring.spot.trial.Service.CategoryTeamsService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping
public class CategoryTeamsController {
    @Autowired
    CategoryTeamsService categoryTeamsService;

    public CategoryTeamsController(CategoryTeamsService categoryTeamsService) {
        this.categoryTeamsService = categoryTeamsService;
    }

    @GetMapping("/categoryteams")
    public List<CategoryTeams> getAllCategoryTeams() {
        return (List<CategoryTeams>) categoryTeamsService.getAllCategoryTeams();
    }

    @GetMapping(value = "/categoryteams/{categoryName}")
    public List<CategoryTeams> getCategoryTeamsByName(@PathVariable("categoryName") String categoryName) {
        return categoryTeamsService.getCategoryTeamsByName(categoryName);
    }

    @PostMapping("/categoryteams")
    public CategoryTeams createCategoryTeams(@RequestBody CategoryTeams categoryTeams) {
        return categoryTeamsService.createCategoryTeams(categoryTeams);
    }

    @PutMapping(value = "/category/{categoryName}")
    public CategoryTeams UpdateCategoryById(@PathVariable("categoryName") String categoryName, @RequestBody CategoryTeams categoryTeams) {
        return categoryTeamsService.updateCategoryTeamsById(categoryName,categoryTeams);
    }
}
