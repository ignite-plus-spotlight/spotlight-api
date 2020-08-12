package spring.spot.trial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.NominationsHistory;
import spring.spot.trial.Service.NominationsHistoryService;

import java.util.Date;
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
    public NominationsHistory createNominationsHistory(@RequestBody NominationsHistory nominationsHistory){return nominationsHistoryService.createNominationsHistory(nominationsHistory);}

   /* @GetMapping("/nominationhistory/manager/{id}/createddate/{date}")
    public NominationsHistory getNominationHistoryByDate(@PathVariable("id") String id,@PathVariable("date") Date date)
    {
        return nominationsHistoryService.getByManagerIdAndDate(id, date);
    }*/
}
