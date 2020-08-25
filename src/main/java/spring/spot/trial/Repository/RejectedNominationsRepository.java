package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.RejectedNominations;

import java.util.List;
import java.util.UUID;

@EnableCassandraRepositories
public interface RejectedNominationsRepository extends CassandraRepository<RejectedNominations, String> {
    List<RejectedNominations> findByRejectedById(String headId);
    List<RejectedNominations> findByRejectedByIdAndProcessId(String headId, UUID processId);
    RejectedNominations findByRejectedByIdAndProcessIdAndNomineeId(String headId,UUID processId,String nomineeId);
    RejectedNominations save(RejectedNominations rejectedNominations);
}
