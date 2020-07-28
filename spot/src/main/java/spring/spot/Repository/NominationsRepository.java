package spring.spot.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.Entity.Nominations;
import spring.spot.Key.NominationsKey;

import java.util.List;


@EnableCassandraRepositories
public interface NominationsRepository extends CassandraRepository<Nominations, NominationsKey> {
    List<Nominations> findByNominationsKeyNominee(int id);
    Nominations save(Nominations nominee);
    Nominations findByNominationsKeyNomineeAndNominationsKeyPeriodName(int id, String periodName);
}

