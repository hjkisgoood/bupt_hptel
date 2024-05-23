package sjk.com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sjk.com.demo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}