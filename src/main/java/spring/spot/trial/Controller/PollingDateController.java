package spring.spot.trial.Controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.PollingDate;
import spring.spot.trial.Service.PollingDateService;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin("*")
@RequestMapping
@RestController
@ResponseBody
@Api(tags = "Polling date Api")
public class PollingDateController {
    @Autowired
    PollingDateService pollingDateService;

    public PollingDateController(PollingDateService pollingDateService) {
        this.pollingDateService = pollingDateService;
    }


    @GetMapping("/pollingDate")
    public List<PollingDate> getAllPollingdates() {
        return pollingDateService.getAllPolling();
    }

    @GetMapping(value = "/pollingDate/start/{startdate}/end/{enddate}")
    public PollingDate getPollingByDates(@PathVariable("startdate") LocalDateTime start, @PathVariable("enddate") LocalDateTime end) {
        return pollingDateService.getPollingByDates(start, end);
    }

    //not used
    @PostMapping("/pollingDate")
    public PollingDate createPollingDate(@RequestBody PollingDate pollingDate) {
        return pollingDateService.createPollingDate(pollingDate);
    }
}
