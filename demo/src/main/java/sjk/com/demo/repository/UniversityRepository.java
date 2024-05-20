package sjk.com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sjk.com.demo.entity.Universities;

import java.util.List;

public interface UniversityRepository extends JpaRepository<Universities, Long> {
}

