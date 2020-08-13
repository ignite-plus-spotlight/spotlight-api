package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.PollingDate;

import java.time.LocalDateTime;

@EnableCassandraRepositories
public interface PollingDateRepository extends CassandraRepository<PollingDate, LocalDateTime> {
    PollingDate findByPollStartDateAndPollEndDate(LocalDateTime pollStartDate, LocalDateTime pollEndDate);
    PollingDate save(PollingDate pollingDate);
}
