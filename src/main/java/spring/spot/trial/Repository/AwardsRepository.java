package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.Awards;

import java.util.List;

@EnableCassandraRepositories
public interface AwardsRepository extends CassandraRepository<Awards, String> {
    Awards save(Awards awards);
    List<Awards> findByAwardName(String awardName);
}
