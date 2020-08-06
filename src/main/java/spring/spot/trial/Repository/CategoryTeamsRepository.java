package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.CategoryTeams;

import java.util.List;

@EnableCassandraRepositories
public interface CategoryTeamsRepository extends CassandraRepository<CategoryTeams, String> {
    List<CategoryTeams> findByCategoryName(String categoryName);
    CategoryTeams save(CategoryTeams categoryTeams);
}
