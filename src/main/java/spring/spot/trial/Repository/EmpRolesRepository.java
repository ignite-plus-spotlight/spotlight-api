package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.EmpRoles;

import java.util.List;

@EnableCassandraRepositories
public interface EmpRolesRepository extends CassandraRepository<EmpRoles, String> {
    List<EmpRoles> findByEmpId(String id);
    EmpRoles save(EmpRoles empRoles);
}
