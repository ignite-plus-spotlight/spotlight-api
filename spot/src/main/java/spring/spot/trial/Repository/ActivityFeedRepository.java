package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.ActivityFeed;

import java.util.List;

@EnableCassandraRepositories
public interface ActivityFeedRepository extends CassandraRepository<ActivityFeed, String> {
    List<ActivityFeed> findByWho(String empOrTeam);
}

