package spring.spot.Repository;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.Entity.Employee;
import spring.spot.Entity.TeamAwards;
import spring.spot.Key.TeamAwardsKey;

import java.util.List;

@EnableCassandraRepositories
public interface TeamAwardsRepository extends CassandraRepository<TeamAwards, TeamAwardsKey> {
    List<TeamAwards> findByTeamAwardsKeyTeamId(int id);
    TeamAwards save(TeamAwards teamAwards);
    TeamAwards findByTeamAwardsKeyTeamIdAndTeamAwardsKeyPeriodName(int id, String periodName);
}
