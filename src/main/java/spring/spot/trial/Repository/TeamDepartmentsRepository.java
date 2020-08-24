package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.TeamDepartments;

import java.util.List;

@EnableCassandraRepositories
public interface TeamDepartmentsRepository extends CassandraRepository<TeamDepartments, String> {
    List<TeamDepartments> findByDepartment(String categoryName);
    TeamDepartments save(TeamDepartments teamDepartments);
}
