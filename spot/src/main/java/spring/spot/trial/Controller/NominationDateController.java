package spring.spot.trial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.EmpRoles;
import spring.spot.trial.Entity.NominationDate;
import spring.spot.trial.Service.NominationDateService;

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
        return (List<NominationDate>) nominationDateService.getAllNominations();
    }

    @GetMapping(value = "/nominationdate/start/{startdate}/end/{enddate}")
    public NominationDate getENominationsByDates(@PathVariable("startdate")Date start, @PathVariable("enddate")Date end) {
        return nominationDateService.getNominationByDates(start, end);
    }

    @PostMapping("/nominationdate")
    public NominationDate createNominationDate(@RequestBody NominationDate nominationDate) {
        return nominationDateService.createNominationDate(nominationDate);
    }

}
