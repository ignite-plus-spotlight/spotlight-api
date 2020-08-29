package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.ActivityFeed;

import java.util.List;
import java.util.UUID;

@EnableCassandraRepositories
public interface ActivityFeedRepository extends CassandraRepository<ActivityFeed, String> {
    List<ActivityFeed> findByAwardeeId(String empOrTeam);
    ActivityFeed findByAwardeeIdAndUuid(String empOrTeam, UUID uuid);
    List<ActivityFeed> findAll();
}
