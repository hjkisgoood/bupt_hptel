package sjk.com.demo.service;

import sjk.com.demo.entity.Room;
import sjk.com.demo.repository.CustomerRepository;
import sjk.com.demo.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sjk.com.demo.entity.Customer;




import java.util.List;
import java.util.Optional;


@Service
public class ReceptionistService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RoomRepository roomRepository;

    /**
     * 顾客入住
     * @param customerId 顾客ID
     * @param roomId 房间ID
     * @return 操作结果
     */
    public String checkIn(Long customerId, Long roomId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        Optional<Room> roomOptional = roomRepository.findById(roomId);

        if (customerOptional.isPresent() && roomOptional.isPresent()) {
            Room room = roomOptional.get();
            if (!room.isOccupied()) {
                room.setOccupied(true);
                roomRepository.save(room);
                return "Check-in successful!";
            } else {
                return "Room is already occupied!";
            }
        } else {
            return "Customer or Room not found!";
        }
    }

    /**
     * 顾客退房
     * @param customerId 顾客ID
     * @param roomId 房间ID
     * @return 操作结果
     */
    public String checkOut(Long customerId, Long roomId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        Optional<Room> roomOptional = roomRepository.findById(roomId);

        if (customerOptional.isPresent() && roomOptional.isPresent()) {
            Room room = roomOptional.get();
            if (room.isOccupied()) {
                room.setOccupied(false);
                roomRepository.save(room);
                return "Check-out successful!";
            } else {
                return "Room is already vacant!";
            }
        } else {
            return "Customer or Room not found!";
        }
    }

    /**
     * 获取所有房间信息
     * @return 房间列表
     */
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
}