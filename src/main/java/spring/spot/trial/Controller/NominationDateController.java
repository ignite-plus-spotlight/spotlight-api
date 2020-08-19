package spring.spot.trial.Controller;

import io.swagger.annotations.Api;
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
@Api(tags = "Nominations date Api")
public class NominationDateController {
    @Autowired
    NominationDateService nominationDateService;

    public NominationDateController(NominationDateService nominationDateService) {
        this.nominationDateService = nominationDateService;
    }


    @GetMapping("/nominationdate")
    public List<NominationDate> getAllNominationdates() {
        return (List<NominationDate>) nominationDateService.getAllNominations();
    }

    @GetMapping(value = "/nominationdate/start/{startdate}/end/{enddate}")
    public NominationDate getENominationsByDates(@PathVariable("startdate") LocalDateTime start, @PathVariable("enddate") LocalDateTime end) {
        return nominationDateService.getNominationByDates(start, end);
    }

    //currently not used
    @PostMapping("/nominationdate")
    public NominationDate createNominationDate(@RequestBody NominationDate nominationDate) {
        return nominationDateService.createNominationDate(nominationDate);
    }

    //to show if current date matches
    @GetMapping("/nominationalert")
    public List<PopUpDTO> alert()
    {
        LocalDateTime Today = LocalDateTime.now();
        return nominationDateService.popUp(Today);
    }

}
