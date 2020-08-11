package spring.spot.trial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.NominationsHistory;
import spring.spot.trial.Service.NominationsHistoryService;

import java.util.List;

@CrossOrigin("*")
@RequestMapping
@RestController
@ResponseBody
public class NominationsHistoryController {
    @Autowired
    NominationsHistoryService nominationsHistoryService;

    public NominationsHistoryController(NominationsHistoryService nominationsHistoryService) {
        this.nominationsHistoryService = nominationsHistoryService;
    }

    @GetMapping("/nominationshistory")
    public List<NominationsHistory> getAllNominationsHistory(){ return nominationsHistoryService.getAllNominationsHistory();}

    @GetMapping("/nominationshistory/manager/{id}")
    public List<NominationsHistory> getNominationsHistoryByManagerId(@PathVariable("id") String id){ return nominationsHistoryService.getNominationsHistoryByManagerId(id);}

    @PostMapping("/nominationshistory")
    public NominationsHistory createNomiationsHistory(@RequestBody NominationsHistory nominationsHistory){return nominationsHistoryService.createNominationsHistory(nominationsHistory);}
}
