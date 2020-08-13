package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.NominationsHistory;
import spring.spot.trial.Repository.EmployeeRepository;
import spring.spot.trial.Repository.NominationsHistoryRepository;
import spring.spot.trial.dto.NominationHistoryDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class NominationsHistoryService {
    @Autowired
    NominationsHistoryRepository nominationsHistoryRepository;

    @Autowired
    EmployeeRepository employeeRepository;

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
        LocalDateTime date = LocalDateTime.now();
        return nominationsHistoryRepository.findByManagerIdAndCreatedDate(id, date);
    }

    public NominationsHistory updateNominationsHistoryById(String id, NominationsHistory nominations) {
        return nominationsHistoryRepository.save(nominations);
    }


    //manager dash board
    public List<NominationHistoryDto> nominationHistory(String managerId)
    {
        List<NominationsHistory> nominationsHistories = nominationsHistoryRepository.findByManagerId(managerId);
        List<NominationHistoryDto> nominationHistoryDtos = new ArrayList<>();
        for(NominationsHistory nominationsHistory : nominationsHistories)
        {
            NominationHistoryDto nominationHistoryDto = new NominationHistoryDto();
            nominationHistoryDto.setCreateDate(nominationsHistory.getCreatedDate());
            nominationHistoryDto.setEmp_id(nominationsHistory.getEmployeeId());
            nominationHistoryDto.setEmployee(employeeRepository.findByEmpId(nominationsHistory.getEmployeeId()).get(0));
            nominationHistoryDto.setManager_id(nominationsHistory.getManagerId());
            nominationHistoryDto.setNominationId(nominationsHistory.getNominationId());
            nominationHistoryDto.setPollName(nominationsHistory.getPollName());
            nominationHistoryDto.setDescription(nominationsHistory.getDescription());
            nominationHistoryDtos.add(nominationHistoryDto);
        }
        return nominationHistoryDtos;
    }
}
