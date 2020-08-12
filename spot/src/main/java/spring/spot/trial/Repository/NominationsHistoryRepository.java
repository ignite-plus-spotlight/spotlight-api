package spring.spot.trial.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import spring.spot.trial.Entity.NominationsHistory;

import java.util.Date;
import java.util.List;

@EnableCassandraRepositories
public interface NominationsHistoryRepository extends CassandraRepository<NominationsHistory,String> {
    List<NominationsHistory> findByManagerId(String id);
    NominationsHistory findByManagerIdAndCreatedDate(String id, Date date);
    NominationsHistory save(NominationsHistory nominationsHistory);
}
