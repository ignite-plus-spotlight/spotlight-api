package spring.spot.trial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.Nominations;
import spring.spot.trial.Service.NominationsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;


@RequestMapping
@ResponseBody
@RestController
@CrossOrigin("*")
public class NominationsController {
    @Autowired
    NominationsService nominationsService;

    public NominationsController (NominationsService nominationsService){
        this.nominationsService = nominationsService;
    }

    @GetMapping("/nominations")
    public List<Nominations> getAllNominations(){
        return nominationsService.getAllNominations();
    }

    @GetMapping("/nominations/{id}")
    public List<Nominations> getAllNominations(@PathVariable("id") String id){
        return (List<Nominations>) nominationsService.getNominationsById(id);
    }

    @GetMapping("/nominations/{id}/{nominationId}")
    public List<Nominations> getAllNominations(@PathVariable("id") String id,@PathVariable("nominationId") String nominationId){
        return (List<Nominations>) nominationsService.getNominationsByPollIdAndNominationId(id,nominationId);
    }

}
