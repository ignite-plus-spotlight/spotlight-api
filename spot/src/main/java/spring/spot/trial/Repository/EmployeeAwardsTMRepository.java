package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.EmployeeAwardsTM;

import java.util.List;

@EnableCassandraRepositories
public interface EmployeeAwardsTMRepository extends CassandraRepository<EmployeeAwardsTM, String> {
    List<EmployeeAwardsTM> findByEmpId(String id);
    List<EmployeeAwardsTM> findByEmpIdAndPeriodName(String id, String period);
    EmployeeAwardsTM save(EmployeeAwardsTM employeeAwardsTM);


}

