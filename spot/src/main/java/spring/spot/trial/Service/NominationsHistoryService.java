package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.NominationsHistory;
import spring.spot.trial.Repository.NominationsHistoryRepository;

import java.util.Date;
import java.util.List;

@Service
public class NominationsHistoryService {
    @Autowired
    NominationsHistoryRepository nominationsHistoryRepository;

    public NominationsHistoryService(NominationsHistoryRepository nominationsHistoryRepository) {
        this.nominationsHistoryRepository = nominationsHistoryRepository;
    }
    public NominationsHistory createNominationsHistory(NominationsHistory nominations) {
        return nominationsHistoryRepository.save(nominations);
    }

    public List<NominationsHistory> getAllNominationsHistory() {
        return nominationsHistoryRepository.findAll();
    }

    public List<NominationsHistory> getNominationsHistoryByManagerId(String manager_id) {
        return nominationsHistoryRepository.findByManagerId(manager_id);
    }

    public NominationsHistory getByManagerIdAndDate(String id)
    {
        Date date = new Date();
        return nominationsHistoryRepository.findByManagerIdAndCreatedDate(id, date);
    }

    public NominationsHistory updateNominationsHistoryById(String id, NominationsHistory nominations) {
        return nominationsHistoryRepository.save(nominations);
    }
}
