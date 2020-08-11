package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.Poll;

@EnableCassandraRepositories
public interface PollRepository extends CassandraRepository<Poll,String> {
    Poll findByPollId(String pollId) ;
    Poll save(Poll poll);
}
