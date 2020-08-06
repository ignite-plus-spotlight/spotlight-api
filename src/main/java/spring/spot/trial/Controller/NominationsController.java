package spring.spot.trial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.Nominations;
import spring.spot.trial.Service.NominationsService;

import java.util.List;

@CrossOrigin("*")
@RequestMapping
@RestController
@ResponseBody

public class NominationsController {
    @Autowired
    NominationsService nominationsService;

    public NominationsController(NominationsService nominationsService) {
        this.nominationsService = nominationsService;
    }

    @GetMapping("/nominations")
    public List<Nominations> getAllNominations() {

        return (List<Nominations>) nominationsService.getAllNominations();
    }

    @GetMapping(value = "/nominations/{id}")
    public List<Nominations> getNominationsByManagerId(@PathVariable("id") String id) {
        return nominationsService.getNominationsByManagerId(id);
    }


    @PostMapping("/nominations")
    public Nominations createNominations(@RequestBody Nominations nominations) {
        return nominationsService.createNominations(nominations);
    }

    @PutMapping(value = "/nominations/{id}")
    public Nominations UpdateNominationsById(@PathVariable("id") String id, @RequestBody Nominations nominations) {
        return nominationsService.updateNominationsById(id,nominations);
    }

}
