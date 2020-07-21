package spring.spot.Repository;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.Entity.TeamAwards;

@EnableCassandraRepositories
public interface TeamAwardsRepository extends CassandraRepository<TeamAwards,Integer> {
    TeamAwards save(TeamAwards teamawards);
}
