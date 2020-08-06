package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.Nominations;

import java.util.List;

@EnableCassandraRepositories
public interface NominationsRepository extends CassandraRepository<Nominations, String> {
    List<Nominations> findByManagerId(String nominee);
    Nominations save(Nominations nominations);
}
