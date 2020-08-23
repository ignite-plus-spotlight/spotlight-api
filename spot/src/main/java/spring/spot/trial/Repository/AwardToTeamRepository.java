package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.AwardToTeam;

import java.util.List;

@EnableCassandraRepositories
public interface AwardToTeamRepository extends CassandraRepository<AwardToTeam,String> {
    AwardToTeam save(AwardToTeam awardToTeam);
    List<AwardToTeam> findByAwardName(String awardName);
}
