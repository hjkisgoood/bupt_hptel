package sjk.com.demo.controller;

import sjk.com.demo.entity.Room;
import sjk.com.demo.service.ReceptionistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receptionist")
public class ReceptionistController {

    @Autowired
    private ReceptionistService receptionistService;

    @PostMapping("/checkin")
    public String checkIn(@RequestParam Long customerId, @RequestParam Long roomId) {
        return receptionistService.checkIn(customerId, roomId);
    }

    @PostMapping("/checkout")
    public String checkOut(@RequestParam Long customerId, @RequestParam Long roomId) {
        return receptionistService.checkOut(customerId, roomId);
    }

    @GetMapping("/rooms")
    public List<Room> getAllRooms() {
        return receptionistService.getAllRooms();
    }
}