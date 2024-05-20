
package sjk.com.demo.service;

import sjk.com.demo.entity.AirCondition;
import sjk.com.demo.repository.AirConditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirConditionService {

    @Autowired
    private AirConditionRepository airConditionRepository;

    public AirCondition addAirCondition(AirCondition airCondition) {
        return airConditionRepository.save(airCondition);
    }

    public AirCondition getAirConditionById(Long id) {
        return airConditionRepository.findById(id).orElse(null);
    }

    public List<AirCondition> getAllAirConditions() {
        return airConditionRepository.findAll();
    }

    public String startSystem() {
        // 假设启动系统的逻辑在这里实现
        return "System started!";
    }

    public String stopSystem() {
        // 假设停止系统的逻辑在这里实现
        return "System stopped!";
    }
}