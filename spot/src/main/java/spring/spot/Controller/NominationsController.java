package spring.spot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.Entity.Employee;
import spring.spot.Entity.Nominations;
import spring.spot.Service.NominationsService;

import java.util.List;

@RestController
public class NominationsController {

    @Autowired
    private NominationsService nominationsService;

    public NominationsController(NominationsService nominationsService) {
        this.nominationsService = nominationsService;
    }

    @GetMapping("/nominations")
    public List<Nominations> getAllNominations() {

        return (List<Nominations>) nominationsService.getAllNominations();
    }


    @GetMapping(value = "/nominations/{id}")
    public List<Nominations> getNominationsById(@PathVariable("id") int id) {
        return nominationsService.getNominationsById(id);
    }

    @GetMapping (value="/nominations/{id}/{periodName}")
    public Nominations findByKeyPeriodName(@PathVariable("id") int id, @PathVariable("periodName") String periodName){
        return nominationsService.findByKeyPeriodName(id, periodName);
    }

    @PostMapping("/nominations")
    public Nominations createNominations(@RequestBody Nominations nominations) {
        return nominationsService.createNominations(nominations);
    }


    @PutMapping(value = "/nominations/{id}")
    public Nominations UpdateNominationsById(@PathVariable("id") int id, @RequestBody Nominations nominations) {
        return nominationsService.updateNominationsById(id,nominations);
    }

}
