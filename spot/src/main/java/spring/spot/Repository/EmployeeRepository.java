package spring.spot.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.Entity.Employee;

@EnableCassandraRepositories
public interface EmployeeRepository extends CassandraRepository<Employee, Integer> {
    Employee save(Employee emp);
}
