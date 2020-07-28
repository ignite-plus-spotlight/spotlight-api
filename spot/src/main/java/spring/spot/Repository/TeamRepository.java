package spring.spot.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.Entity.Team;
import spring.spot.Key.TeamKey;

import java.util.List;


@EnableCassandraRepositories
public interface TeamRepository extends CassandraRepository<Team, TeamKey> {
    List<Team> findByTeamKeyTeamId(int id);
    Team save(Team team);
}

