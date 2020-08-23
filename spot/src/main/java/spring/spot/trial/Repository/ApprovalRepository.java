package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.Approval;

import java.util.List;
import java.util.UUID;

@EnableCassandraRepositories
public interface ApprovalRepository extends CassandraRepository<Approval, String> {
    List<Approval> findByApprovedById(String headId);
    Approval findByApprovedByIdAndProcessIdAndNominationId(String headId, UUID processId, UUID nominationId);
    Approval save(Approval approval);

    List<Approval> findByApprovedByIdAndProcessId(String yourEmpId, UUID pId);
}
