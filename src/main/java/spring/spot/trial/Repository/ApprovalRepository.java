package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.Approval;

import java.util.List;
import java.util.UUID;

@EnableCassandraRepositories
public interface ApprovalRepository extends CassandraRepository<Approval, UUID> {
    //Approval findById(UUID nominationId);
    List<Approval> findByIdAndHeadId(UUID nominationId,String headId);
    Approval save(Approval approval);



}
