package spring.spot.trial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.EmpRoles;
import spring.spot.trial.Entity.NominationDate;
import spring.spot.trial.Service.NominationDateService;
import spring.spot.trial.dto.PopUpDTO;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@CrossOrigin("*")
@RequestMapping
@RestController
@ResponseBody
public class NominationDateController {
    @Autowired
    NominationDateService nominationDateService;

    public NominationDateController(NominationDateService nominationDateService) {
        this.nominationDateService = nominationDateService;
    }


    @GetMapping("/nominationdate")
    public List<NominationDate> getAllNominationdates() {
        return nominationDateService.getAllNominations();
    }

    @GetMapping(value = "/nominationdate/start/{startdate}/end/{enddate}")
    public NominationDate getENominationsByDates(@PathVariable("startdate") LocalDateTime start, @PathVariable("enddate") LocalDateTime end) {
        return nominationDateService.getNominationByDates(start, end);
    }

    @PostMapping("/nominationdate")
    public NominationDate createNominationDate(@RequestBody NominationDate nominationDate) {
        return nominationDateService.createNominationDate(nominationDate);
    }

    //head gets the notification of the nomination process that was started(head = manager or director)
    @GetMapping("/nominationalert/{yourId}")
    public List<PopUpDTO> alert(@PathVariable("yourId") String id)
    {
        LocalDateTime Today = LocalDateTime.now();
        return nominationDateService.popUp(Today,id);
    }
}
