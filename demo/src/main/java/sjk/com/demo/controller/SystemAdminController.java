package sjk.com.demo.controller;

import sjk.com.demo.entity.AirCondition;
import sjk.com.demo.service.AirConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/systemadmin")
public class SystemAdminController {

    @Autowired
    private AirConditionService airConditionService;

    @PostMapping("/aircondition")
    public AirCondition addAirCondition(@RequestBody AirCondition airCondition) {
        return airConditionService.addAirCondition(airCondition);
    }

    @GetMapping("/aircondition/{id}")
    public AirCondition getAirCondition(@PathVariable Long id) {
        return airConditionService.getAirConditionById(id);
    }

    @GetMapping("/airconditions")
    public List<AirCondition> getAllAirConditions() {
        return airConditionService.getAllAirConditions();
    }

    @PostMapping("/start")
    public String startSystem() {
        return airConditionService.startSystem();
    }

    @PostMapping("/stop")
    public String stopSystem() {
        return airConditionService.stopSystem();
    }
}
