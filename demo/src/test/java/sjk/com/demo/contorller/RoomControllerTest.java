package sjk.com.demo.contorller;


import sjk.com.demo.controller.*;
import sjk.com.demo.entity.*;
import sjk.com.demo.service.RoomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RoomController.class)
public class RoomControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoomService roomService;

    private Room room1;
    private Room room2;

    @BeforeEach
    public void setup() {
        room1 = new Room();
        room1.setId(1L);
        room1.setCurrentTemperature(26);
        room1.setAirConditionOn(false);
        room1.setFanSpeed(0);
        room1.setMode(0);
        room1.setDailyRent(100.0);

        room2 = new Room();
        room2.setId(2L);
        room2.setCurrentTemperature(26);
        room2.setAirConditionOn(false);
        room2.setFanSpeed(0);
        room2.setMode(0);
        room2.setDailyRent(100.0);
    }

    @Test
    public void testAddRoom() throws Exception {
        given(roomService.addRoom(any(Room.class))).willReturn(room1);

        String roomJson = "{\"currentTemperature\":26,\"isAirConditionOn\":false,\"fanSpeed\":0,\"mode\":0,\"dailyRent\":100.0}";

        mockMvc.perform(post("/api/rooms")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(roomJson))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"currentTemperature\":26,\"airConditionOn\":false,\"fanSpeed\":0,\"mode\":0,\"dailyRent\":100.0}"));
    }

    @Test
    public void testGetRoom() throws Exception {
        given(roomService.getRoomById(anyLong())).willReturn(room1);

        mockMvc.perform(get("/api/rooms/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"currentTemperature\":26,\"airConditionOn\":false,\"fanSpeed\":0,\"mode\":0,\"dailyRent\":100.0}"));
    }

    @Test
    public void testGetAllRooms() throws Exception {
        List<Room> rooms = Arrays.asList(room1, room2);
        given(roomService.getAllRooms()).willReturn(rooms);

        mockMvc.perform(get("/api/rooms"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"currentTemperature\":26,\"airConditionOn\":false,\"fanSpeed\":0,\"mode\":0,\"dailyRent\":100.0},{\"id\":2,\"currentTemperature\":26,\"airConditionOn\":false,\"fanSpeed\":0,\"mode\":0,\"dailyRent\":100.0}]"));
    }

    @Test
    public void testUpdateRoom() throws Exception {
        given(roomService.updateRoom(anyLong(), any(Integer.class), any(Integer.class), any(Integer.class), any(Boolean.class)))
                .willReturn("Room updated successfully!");

        mockMvc.perform(post("/api/rooms/update")
                        .param("roomId", "1")
                        .param("temp", "24")
                        .param("fanSpeed", "2")
                        .param("mode", "1")
                        .param("on", "true"))
                .andExpect(status().isOk())
                .andExpect(content().string("Room updated successfully!"));
    }
}
