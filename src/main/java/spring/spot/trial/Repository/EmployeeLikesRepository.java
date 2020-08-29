package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.EmpLikes;

import java.util.UUID;

@EnableCassandraRepositories
public interface EmployeeLikesRepository extends CassandraRepository<EmpLikes,String> {
    EmpLikes findByAwardeeIdAndUuidAndEmpId(String awardeeId, UUID uuid, String empId);
}