package spring.spot.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.Entity.Roles;
import spring.spot.Key.RolesKey;

import java.util.List;


@EnableCassandraRepositories
public interface RolesRepository extends CassandraRepository<Roles, RolesKey> {
    List<Roles> findByRolesKeyRoleName(String name);
    Roles save (Roles roles);

}
