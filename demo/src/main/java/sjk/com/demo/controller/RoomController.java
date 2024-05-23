package sjk.com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sjk.com.demo.entity.Room;
import sjk.com.demo.service.RoomService;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @PostMapping
    public Room addRoom(@RequestBody Room room) {
        return roomService.addRoom(room);
    }

    @GetMapping("/{id}")
    public Room getRoom(@PathVariable Long id) {
        return roomService.getRoomById(id);
    }

    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @PostMapping("/update")
    public String updateRoom(@RequestParam Long roomId,
                             @RequestParam(required = false) Integer temp,
                             @RequestParam(required = false) Integer fanSpeed,
                             @RequestParam(required = false) Integer mode,
                             @RequestParam(required = false) Boolean on) {
        return roomService.updateRoom(roomId, temp, fanSpeed, mode, on);
    }
}
