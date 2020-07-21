package spring.spot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public Nominations getNominationsById(@PathVariable("id") int id) {
        return nominationsService.getNominationsById(id);
    }


    @PostMapping("/nominations")
    public Nominations createNominations(@RequestBody Nominations nominee) {

        return nominationsService.createNominations(nominee);
    }


    @PutMapping(value = "/nominations/{id}")
    public Nominations UpdateNominationsById(@PathVariable("id") int id, @RequestBody Nominations nominee) {
        return nominationsService.updateNominationsById(id,nominee);
    }


    @DeleteMapping(value = "/nominations/{id}")
    public String deleteNominationsById(@PathVariable("id") int id) {
        nominationsService.deleteNominationsById(id);
        return "Nomination with id " + id + " has been deleted!";
    }
}
