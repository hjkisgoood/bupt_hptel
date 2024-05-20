package sjk.com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sjk.com.demo.entity.Dormitories;

import java.util.List;

@Repository
public interface DormitoryRepository extends JpaRepository<Dormitories, Long> {

    // 可以在这里添加自定义的查询方法
}
