package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import spring.spot.trial.Entity.PollStatus;

import java.util.List;

@EnableCassandraRepositories
public interface PollStatusRepository extends CassandraRepository<PollStatus,String> {
    List<PollStatus> findByPollId(String pollId);
//    List<PollStatus> findByPollIdAndNominationId(String pollId, String nominationId);
    PollStatus save(PollStatus pollStatus);

}
