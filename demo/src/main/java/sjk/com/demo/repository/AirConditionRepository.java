package sjk.com.demo.repository;



import sjk.com.demo.entity.AirCondition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirConditionRepository extends JpaRepository<AirCondition, Long> {
}
