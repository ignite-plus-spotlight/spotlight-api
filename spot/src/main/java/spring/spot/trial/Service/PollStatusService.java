package spring.spot.trial.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.Nominations;
import spring.spot.trial.Entity.PollStatus;
import spring.spot.trial.Exception.NotFoundException;
import spring.spot.trial.Repository.EmployeeRepository;
import spring.spot.trial.Repository.NominationsRepository;
import spring.spot.trial.Repository.PollRepository;
import spring.spot.trial.Repository.PollStatusRepository;
import spring.spot.trial.dto.WinnerDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class PollStatusService {
    @Autowired
    PollStatusRepository pollStatusRepository;
    @Autowired
    NominationsRepository nominationsRepository;
    @Autowired
    PollRepository pollRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    public PollStatusService(PollStatusRepository pollStatusRepository) {
        this.pollStatusRepository = pollStatusRepository;
    }

    public List<PollStatus> getAllPollStatus(){
        List<PollStatus> pollStatuses = pollStatusRepository.findAll();
        if(pollStatuses.isEmpty())
            throw new NotFoundException("No poll statuses found!");
        return pollStatuses;
    }

    public List<PollStatus> getAllByPollId(UUID id){
        List<PollStatus> pollStatuses = pollStatusRepository.findByPollId(id);
        if(pollStatuses.isEmpty())
            throw new NotFoundException("No poll status with id "+id+" found");
        return pollStatusRepository.findByPollId(id);
    }

    public PollStatus getAllByPollIdAndNominationId(UUID id,UUID nominationId){
        PollStatus pollStatus = pollStatusRepository.findByPollIdAndNominationId(id,nominationId);
        if(pollStatus == null)
            throw new NotFoundException("Not poll status for nomination id "+id+" found");
        return pollStatusRepository.findByPollIdAndNominationId(id,nominationId);
    }

    public PollStatus createPollStatus(PollStatus pollStatus) {
        return pollStatusRepository.save(pollStatus);
    }

    //increment vote count
    public PollStatus increment(UUID pollId, UUID nominationId)
    {
        PollStatus pollStatus = pollStatusRepository.findByPollIdAndNominationId(pollId,nominationId);
        pollStatus.setVoteCount(pollStatus.getVoteCount()+1);
        return pollStatusRepository.save(pollStatus);
    }

    //announce winner
    public WinnerDTO win(UUID pollId)
    {
        List<PollStatus> pollStatuses =  pollStatusRepository.findByPollId(pollId);
        List<Integer> votes = new ArrayList<>();
        UUID nominationID=null;
        int max = 0;
        for (PollStatus pollStatus : pollStatuses)
        {
          votes.add(pollStatus.getVoteCount());
           max = Collections.max(votes);
        }

        for (PollStatus pollStatus : pollStatuses)
        {
            if(max == pollStatus.getVoteCount())
            {
                nominationID=pollStatus.getNominationId();
            }
        }

       Nominations nominations = nominationsRepository.findByPollIdAndNominationId(pollId,nominationID);
        WinnerDTO winnerDTO = new WinnerDTO();
        winnerDTO.setEmpId(nominations.getEmployeeId());
        winnerDTO.setNominationId(nominationID);
        winnerDTO.setPollId(pollId);
        winnerDTO.setPollName((pollRepository.findByPollId(pollId)).getPollName());
        winnerDTO.setEmployee(employeeRepository.findByEmpId(nominations.getEmployeeId()).get(0));
        return winnerDTO;
    }

}
