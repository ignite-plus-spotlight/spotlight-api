package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.Nominations;
import java.util.List;
import java.util.UUID;

@EnableCassandraRepositories
public interface NominationsRepository extends CassandraRepository<Nominations,String> {
    List<Nominations> findByManagerId(String headId);
    Nominations findByManagerIdAndPollId(String headId, UUID pollId);
    Nominations save(Nominations nominations);

}
