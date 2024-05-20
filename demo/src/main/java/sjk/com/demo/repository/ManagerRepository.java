package sjk.com.demo.repository;

import sjk.com.demo.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ManagerRepository extends JpaRepository<Manager, Long> {
}