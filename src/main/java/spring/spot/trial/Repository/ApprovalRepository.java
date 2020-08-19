package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.Approval;

import java.util.List;
import java.util.UUID;

@EnableCassandraRepositories
public interface ApprovalRepository extends CassandraRepository<Approval, UUID> {
    List<Approval> findByNominationId(UUID nominationId);
    Approval save(Approval approval);



}
