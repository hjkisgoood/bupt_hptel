package sjk.com.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sjk.com.demo.entity.*;
import sjk.com.demo.repository.*;


import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room getRoomById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public String updateRoom(Long roomId, Integer temp, Integer fanSpeed, Integer mode, Boolean on) {
        Optional<Room> roomOptional = roomRepository.findById(roomId);
        if (roomOptional.isPresent()) {
            Room room = roomOptional.get();
            if (temp != null) {
                room.setCurrentTemperature(temp);
            }
            if (fanSpeed != null) {
                room.setFanSpeed(fanSpeed);
            }
            if (mode != null) {
                room.setMode(mode);
            }
            if (on != null) {
                room.setAirConditionOn(on);
            }
            roomRepository.save(room);
            return "Room updated successfully!";
        } else {
            return "Room not found!";
        }
    }

    public void updateRoomTemperature(Room room) {
        if (room.isAirConditionOn()) {
            int changeRate = room.getFanSpeed();
            if (room.getMode() == 0) { // Cooling
                room.setCurrentTemperature(room.getCurrentTemperature() - changeRate);
            } else { // Heating
                room.setCurrentTemperature(room.getCurrentTemperature() + changeRate);
            }
        } else {
            if (room.getCurrentTemperature() > room.getDefaultTemperature()) {
                room.setCurrentTemperature(room.getCurrentTemperature() - 1);
            } else if (room.getCurrentTemperature() < room.getDefaultTemperature()) {
                room.setCurrentTemperature(room.getCurrentTemperature() + 1);
            }
        }
    }
}
