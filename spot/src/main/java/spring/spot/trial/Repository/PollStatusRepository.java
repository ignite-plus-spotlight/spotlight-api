package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import spring.spot.trial.Entity.PollStatus;

import java.util.List;
import java.util.UUID;

@EnableCassandraRepositories
public interface PollStatusRepository extends CassandraRepository<PollStatus,UUID> {
    List<PollStatus> findByPollId(UUID pollId);
    PollStatus findByPollIdAndNominationId(UUID pollId, UUID nominationId);
    PollStatus save(PollStatus pollStatus);

}
