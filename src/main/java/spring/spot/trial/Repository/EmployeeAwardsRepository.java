package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.EmployeeAwards;

import java.util.List;

@EnableCassandraRepositories
public interface EmployeeAwardsRepository extends CassandraRepository<EmployeeAwards, String> {
    List<EmployeeAwards> findByEmpId(String id);
    EmployeeAwards save(EmployeeAwards employeeAwards);
}
