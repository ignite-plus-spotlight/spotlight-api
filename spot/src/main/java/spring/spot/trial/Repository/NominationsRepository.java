package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.Nominations;
import java.util.List;

@EnableCassandraRepositories
public interface NominationsRepository extends CassandraRepository<Nominations,String> {
    List<Nominations> findByPollId(String pollId);
    List<Nominations> findByPollIdAndNominationId(String pollId,String nominationId);
    Nominations save(Nominations nominations);

}
