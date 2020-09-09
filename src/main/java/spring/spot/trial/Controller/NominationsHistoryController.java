package spring.spot.trial.Controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.NominationsHistory;
import spring.spot.trial.Service.NominationsHistoryService;
import spring.spot.trial.dto.NominationHistoryDto;

import java.util.List;

@CrossOrigin("*")
@RequestMapping
@RestController
@Api(tags = "Nominations History")
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


    @GetMapping("/nominationhistory/manager/{id}/createddate")
    public NominationsHistory getNominationHistoryByDate(@PathVariable("id") String id)
    {
        return nominationsHistoryService.getByManagerIdAndDate(id);
    }

    //head views the history of nominations done by him or her
    @GetMapping("nominationhistoryfromdto/manager/{managerId}")
    public List<NominationHistoryDto> history(@PathVariable("managerId") String managerId)
    {
        return nominationsHistoryService.nominationHistory(managerId);
    }
}
