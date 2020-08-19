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
@ResponseBody
@Api(tags = "Nominations history Api")
public class NominationsHistoryController {
    @Autowired
    NominationsHistoryService nominationsHistoryService;

    public NominationsHistoryController(NominationsHistoryService nominationsHistoryService) {
        this.nominationsHistoryService = nominationsHistoryService;
    }

    @GetMapping("/nominationshistory")
    public List<NominationsHistory> getAllNominationsHistory(){ return nominationsHistoryService.getAllNominationsHistory();}

    @GetMapping("/nominationshistory/head/{id}")
    public List<NominationsHistory> getNominationsHistoryByManagerId(@PathVariable("id") String id){ return nominationsHistoryService.getNominationsHistoryByHeadId(id);}

    @PostMapping("/nominationshistory")
    public NominationsHistory createNominationsHistory(@RequestBody NominationsHistory nominationsHistory){return nominationsHistoryService.createNominationsHistory(nominationsHistory);}


    @GetMapping("/nominationhistory/head/{id}/createddate")
    public NominationsHistory getNominationHistoryByDate(@PathVariable("id") String id)
    {
        return nominationsHistoryService.getByHeadIdAndDate(id);
    }

    @GetMapping("nominationhistoryfromdto/head/{headId}")
    public List<NominationHistoryDto> history(@PathVariable("headId") String headId)
    {
        return nominationsHistoryService.nominationHistory(headId);
    }
}
