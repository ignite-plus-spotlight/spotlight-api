package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.TeamAwardsMD;

import java.util.List;

@EnableCassandraRepositories
public interface TeamAwardsMDRepository extends CassandraRepository<TeamAwardsMD, String> {
    List<TeamAwardsMD> findByManagerId(String id);
    TeamAwardsMD save(TeamAwardsMD teamAwardsMD);
}
