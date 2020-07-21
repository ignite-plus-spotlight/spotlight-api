package spring.spot.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.Entity.Roles;

import java.util.Optional;

@EnableCassandraRepositories
public interface RolesRepository extends CassandraRepository<Roles, String> {
    Roles save(Roles roles);

}
