package spring.spot.trial.Repository;


import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.Roles;

@EnableCassandraRepositories
public interface RolesRepository extends CassandraRepository<Roles, String> {
    Roles save(Roles roles);
}