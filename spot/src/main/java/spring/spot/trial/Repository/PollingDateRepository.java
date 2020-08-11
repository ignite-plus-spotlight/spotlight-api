package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.PollingDate;

import java.util.Date;

@EnableCassandraRepositories
public interface PollingDateRepository extends CassandraRepository<PollingDate, Date> {
    PollingDate findByPollStartDateAndPollEndDate(Date pollStartDate, Date pollEndDate);
    PollingDate save(PollingDate pollingDate);
}
