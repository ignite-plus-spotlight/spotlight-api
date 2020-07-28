package spring.spot.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.Entity.Employee;
import spring.spot.Key.EmployeeKey;

import java.util.List;

@EnableCassandraRepositories
public interface EmployeeRepository extends CassandraRepository<Employee, EmployeeKey> {
    List<Employee> findByEmployeeKeyEmpId(int id);
    Employee save(Employee employee);
    Employee findByEmployeeKeyEmpIdAndEmployeeKeyFirstName(int id, String firstName);
}