package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.Poll;

import java.util.UUID;

@EnableCassandraRepositories
public interface PollRepository extends CassandraRepository<Poll,String> {
    Poll findByPollId(UUID pollId) ;
    Poll save(Poll poll);
}
