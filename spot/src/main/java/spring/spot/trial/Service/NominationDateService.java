package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.NominationDate;
import spring.spot.trial.Entity.Poll;
import spring.spot.trial.Repository.NominationDateRepository;
import spring.spot.trial.Repository.PollRepository;
import spring.spot.trial.dto.PopUpDTO;

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

    public NominationDateService(NominationDateRepository nominationDateRepository) {
        this.nominationDateRepository = nominationDateRepository;
    }

    public NominationDate createNominationDate(NominationDate nominationDate) {
        return nominationDateRepository.save(nominationDate);
    }

    public List<NominationDate> getAllNominations() {
        return nominationDateRepository.findAll();
    }

    public NominationDate getNominationByDates(Date start, Date end) {
        return nominationDateRepository.findByNominationStartDateAndNominationEndDate(start,end);
    }


    //manager pop up to nominate based on date
    //check in nominations table for the current date
    //if its today return dto

    public List<PopUpDTO> popUp(Date Today)
    {
        List<PopUpDTO> popUpDTOS = new ArrayList<>();

        List<NominationDate> nominationDates = nominationDateRepository.findAll();
        for (NominationDate nominationDate : nominationDates)
        {
            PopUpDTO popUpDTO = new PopUpDTO();
            String description;
            String pollName;
           Date startDate =  nominationDate.getNominationStartDate();
           Date endDate = nominationDate.getNominationEndDate();
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
               popUpDTOS.add(popUpDTO);

           }

        }
        return popUpDTOS;
    }

}
