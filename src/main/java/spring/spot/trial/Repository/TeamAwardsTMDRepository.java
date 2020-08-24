package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.TeamAwardsTMD;

import java.util.List;

@EnableCassandraRepositories
public interface TeamAwardsTMDRepository extends CassandraRepository<TeamAwardsTMD,Integer> {
    List<TeamAwardsTMD> findByEmployeeId(String id);
}
