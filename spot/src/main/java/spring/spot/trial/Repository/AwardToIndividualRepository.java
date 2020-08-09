package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.AwardToIndividual;

import java.util.List;

@EnableCassandraRepositories
public interface AwardToIndividualRepository extends CassandraRepository<AwardToIndividual, String> {
    AwardToIndividual save(AwardToIndividual awardToIndividual);
    List<AwardToIndividual> findByAwardName(String awardName);
}
