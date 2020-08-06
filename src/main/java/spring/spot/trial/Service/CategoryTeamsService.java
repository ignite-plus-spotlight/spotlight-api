package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.CategoryTeams;
import spring.spot.trial.Repository.CategoryTeamsRepository;

import java.util.List;

@Service
public class CategoryTeamsService {
    @Autowired
    CategoryTeamsRepository categoryTeamsRepository;

    public CategoryTeamsService(CategoryTeamsRepository categoryTeamsRepository) {
        this.categoryTeamsRepository = categoryTeamsRepository;
    }

    public CategoryTeams createCategoryTeams(CategoryTeams categoryTeams){
        return categoryTeamsRepository.save(categoryTeams);
    }

    public List<CategoryTeams> getAllCategoryTeams(){
        return categoryTeamsRepository.findAll();
    }

    public List<CategoryTeams> getCategoryTeamsByName(String categoryName){
        return categoryTeamsRepository.findByCategoryName(categoryName);
    }

    public CategoryTeams updateCategoryTeamsById(String name, CategoryTeams cat) {
        return categoryTeamsRepository.save(cat);
    }
}
