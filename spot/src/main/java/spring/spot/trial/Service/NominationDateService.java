package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.NominationDate;
import spring.spot.trial.Entity.Nominations;
import spring.spot.trial.Entity.Poll;
import spring.spot.trial.Exception.NotAcceptableException;
import spring.spot.trial.Exception.NotFoundException;
import spring.spot.trial.Repository.NominationDateRepository;
import spring.spot.trial.Repository.NominationsRepository;
import spring.spot.trial.Repository.PollRepository;
import spring.spot.trial.dto.PopUpDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class NominationDateService {
@Autowired
NominationDateRepository nominationDateRepository;

@Autowired
    PollRepository pollRepository;
@Autowired
    NominationsRepository nominationsRepository;

    public NominationDateService(NominationDateRepository nominationDateRepository) {
        this.nominationDateRepository = nominationDateRepository;
    }
    public NominationDate createNominationDate(NominationDate nominationDate) {
        if((nominationDate.getNominationStartDate().compareTo(nominationDate.getNominationEndDate())==0) || (nominationDate.getNominationStartDate().compareTo(nominationDate.getNominationEndDate())>0))
            throw new NotAcceptableException("Give a valid dates");
        return nominationDateRepository.save(nominationDate);
    }

    public List<NominationDate> getAllNominations() {
        return nominationDateRepository.findAll();
    }

    public NominationDate getNominationByDates(LocalDateTime start, LocalDateTime end) {
        NominationDate nominationDate = nominationDateRepository.findByNominationStartDateAndNominationEndDate(start,end);
        if(nominationDate == null)
            throw new NotFoundException("No nomination found");
        return nominationDateRepository.findByNominationStartDateAndNominationEndDate(start,end);
    }

    //manager pop up to nominate based on date
    //check in nominations table for the current date
    //if its today return dto
    //if already nominated, don't show this

    public List<PopUpDTO> popUp(LocalDateTime Today,String yourId)
    {
        List<PopUpDTO> popUpDTOS = new ArrayList<>();

        List<NominationDate> nominationDates = nominationDateRepository.findAll();
        for (NominationDate nominationDate : nominationDates)
        {
            PopUpDTO popUpDTO = new PopUpDTO();
            String description;
            String pollName;
           LocalDateTime startDate =  nominationDate.getNominationStartDate();
           LocalDateTime endDate = nominationDate.getNominationEndDate();
            NominationDate n = new NominationDate();
           if(Today.compareTo(startDate)>=0 && Today.compareTo(endDate)<=0)
                 n = nominationDateRepository.findByNominationStartDateAndNominationEndDate(startDate,endDate);

           else
               n = null;
           if(n!=null)
           {
               UUID pollId = n.getPollId();
               Poll poll = pollRepository.findByPollId(pollId);
               description = poll.getDescription();
               pollName = poll.getPollName();
               popUpDTO.setDescription(description);
               popUpDTO.setNominationEndDate(endDate);
               popUpDTO.setNominationStartDate(startDate);
               popUpDTO.setPollName(pollName);
               if (nominationsRepository.findByManagerIdAndPollId(yourId,pollId) != null)
               popUpDTOS.add(popUpDTO);
           }

        }
        return popUpDTOS;
    }

}
