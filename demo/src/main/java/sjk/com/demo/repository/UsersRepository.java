package sjk.com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sjk.com.demo.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
}
