package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.IndividualTeamAwards;

import java.util.List;

@EnableCassandraRepositories
public interface IndividualTeamAwardsRepository extends CassandraRepository<IndividualTeamAwards, String> {
    List<IndividualTeamAwards> findByEmpId(String empId);
    IndividualTeamAwards save (IndividualTeamAwards individualTeamAwards);
}
