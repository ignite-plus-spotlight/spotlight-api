package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.Team;

import java.util.List;

@EnableCassandraRepositories
public interface TeamRepository extends CassandraRepository<Team, String> {
    Team save(Team team);
    List<Team> findByHeadId(String headId);
    Team findByHeadIdAndTeamId(String headId, int teamId);
}