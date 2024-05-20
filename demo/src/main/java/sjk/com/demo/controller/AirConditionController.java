package sjk.com.demo.controller;


import sjk.com.demo.entity.AirCondition;
import sjk.com.demo.service.AirConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airconditions")
public class AirConditionController {

    @Autowired
    private AirConditionService airConditionService;

    @PostMapping
    public AirCondition addAirCondition(@RequestBody AirCondition airCondition) {
        return airConditionService.addAirCondition(airCondition);
    }

    @GetMapping("/{id}")
    public AirCondition getAirCondition(@PathVariable Long id) {
        return airConditionService.getAirConditionById(id);
    }

    @GetMapping
    public List<AirCondition> getAllAirConditions() {
        return airConditionService.getAllAirConditions();
    }
}
