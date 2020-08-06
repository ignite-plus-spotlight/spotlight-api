package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.TeamAwardsMD;

import java.util.List;

@EnableCassandraRepositories
public interface TeamAwardsRepository extends CassandraRepository<TeamAwardsMD, String> {
    List<TeamAwardsMD> findByManagerId(String id);
   // List<TeamAwardsMD> findByTeamId(int id);
    TeamAwardsMD save(TeamAwardsMD teamAwardsMD);

}
