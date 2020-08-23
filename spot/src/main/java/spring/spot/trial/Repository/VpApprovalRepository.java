package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.VpApproval;

import java.util.UUID;

@EnableCassandraRepositories
public interface VpApprovalRepository extends CassandraRepository<VpApproval, String> {
    VpApproval findByApprovedByIdAndProcessIdAndNomineeId(String approvedId, UUID processId, String nomineeId);
    VpApproval save(VpApproval vpApproval);
}
