package sjk.com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sjk.com.demo.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
