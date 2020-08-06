package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.EmployeeAwardsMD;

import java.util.List;

@EnableCassandraRepositories
public interface EmployeeAwardsMRepository extends CassandraRepository<EmployeeAwardsMD,String> {
    List<EmployeeAwardsMD> findByAwardedById(String id);
    EmployeeAwardsMD save(EmployeeAwardsMD employeeAwardsMD);
}