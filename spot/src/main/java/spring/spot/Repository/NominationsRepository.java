package spring.spot.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.Entity.Nominations;


@EnableCassandraRepositories
public interface NominationsRepository extends CassandraRepository<Nominations, Integer> {
    Nominations save(Nominations nominee);
}

