package sjk.com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sjk.com.demo.entity.Bill;
import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Long> {
    List<Bill> findByCustomerId(Long customerId);
}
