package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.Approval;

import java.util.List;
import java.util.UUID;

@EnableCassandraRepositories
public interface ApprovalRepository extends CassandraRepository<Approval, String> {
    List<Approval> findByApprovedById(String headId);
    List<Approval> findByApprovedByIdAndProcessId(String headId, UUID processId);
    Approval findByApprovedByIdAndProcessIdAndNomineeId(String headId,UUID processId,String nomineeId);
    Approval save(Approval approval);
}

