package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.TeamAwardsDirector;

import java.util.List;

@EnableCassandraRepositories

public interface TeamAwardsDirectorRepository extends CassandraRepository<TeamAwardsDirector, String> {
    List<TeamAwardsDirector> findByAwardedById(String awardedById);
    TeamAwardsDirector save (TeamAwardsDirector teamAwardsDirector);
}
