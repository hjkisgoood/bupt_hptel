package sjk.com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sjk.com.demo.entity.Canteens;

import java.util.List;

public interface CanteenRepository extends JpaRepository<Canteens, Long> {

}
