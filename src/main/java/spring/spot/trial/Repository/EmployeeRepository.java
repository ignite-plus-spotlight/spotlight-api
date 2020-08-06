package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.Employee;

import java.util.List;

@EnableCassandraRepositories
public interface EmployeeRepository extends CassandraRepository<Employee, String> {
    List<Employee> findByEmpId(String id);
    Employee save(Employee employee);
    Employee findByEmpIdAndFirstName(String id, String firstName);
}

