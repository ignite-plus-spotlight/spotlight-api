package spring.spot.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.Entity.Team;


@EnableCassandraRepositories
public interface TeamRepository extends CassandraRepository<Team, Integer> {
    Team save(Team team);
}

