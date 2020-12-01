package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.NominationDate;

import java.time.LocalDateTime;
import java.util.Date;

@EnableCassandraRepositories
public interface NominationDateRepository extends CassandraRepository<NominationDate, LocalDateTime> {
    NominationDate findByNominationStartDateAndNominationEndDate(LocalDateTime nominationStartDate, LocalDateTime nominationEndDate);
    NominationDate save(NominationDate nominationDate);
}
