package sjk.com.demo.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import sjk.com.demo.entity.Room;
import sjk.com.demo.service.RoomService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

@Service
public class AirConditionScheduler {

    @Autowired
    private RoomService roomService;

    private final int MAX_ACTIVE_ROOMS = 3;

    @Scheduled(fixedRate = 20000) // 20 seconds equivalent to 1 hour in hotel system
    public void scheduleAirConditioning() {
        List<Room> rooms = roomService.getAllRooms();

        // Separate rooms based on air conditioner state
        List<Room> activeRooms = new ArrayList<>();
        List<Room> inactiveRooms = new ArrayList<>();

        for (Room room : rooms) {
            if (room.isAirConditionOn()) {
                activeRooms.add(room);
            } else {
                inactiveRooms.add(room);
            }
        }

        // Sort active rooms based on fan speed and time (priority queue)
        Queue<Room> activeQueue = new PriorityQueue<>(Comparator.comparingInt(Room::getFanSpeed).reversed());

        activeQueue.addAll(activeRooms);

        // Schedule air conditioning based on priority
        int count = 0;
        while (!activeQueue.isEmpty() && count < MAX_ACTIVE_ROOMS) {
            Room room = activeQueue.poll();
            room.setAirConditionOn(true);
            roomService.updateRoomTemperature(room);
            count++;
        }

        // Turn off air conditioner for remaining rooms
        while (!activeQueue.isEmpty()) {
            Room room = activeQueue.poll();
            room.setAirConditionOn(false);
            roomService.updateRoomTemperature(room);
        }

        // Adjust inactive room temperatures towards default
        for (Room room : inactiveRooms) {
            roomService.updateRoomTemperature(room);
        }
    }
}
