package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.Approval;

@EnableCassandraRepositories
public interface ApprovalRepository extends CassandraRepository<Approval, String> {
    Approval findByApprovedById(String headId);
    Approval save(Approval approval);
}
