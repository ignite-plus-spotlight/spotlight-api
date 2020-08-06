package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.Team;

import java.util.List;

@EnableCassandraRepositories
public interface TeamRepository extends CassandraRepository<Team, String> {
    Team save(Team team);
    List<Team> findByManagerId (String managerId);
    Team findByManagerIdAndTeamId(String managerId, int teamId);
}