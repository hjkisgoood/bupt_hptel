package sjk.com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import sjk.com.demo.entity.Room;

import java.util.List;

@Service
public class SchedulerService {

    @Autowired
    private RoomService roomService;

    @Scheduled(fixedRate = 20000) // 20 seconds equivalent to 1 hour in hotel system
    public void updateSystemState() {
        List<Room> rooms = roomService.getAllRooms();
        for (Room room : rooms) {
            roomService.updateRoomTemperature(room);
            // Assuming roomRepository.save(room) is called within updateRoomTemperature
        }
        // Additional logic for air conditioner scheduling can be added here
    }
}
