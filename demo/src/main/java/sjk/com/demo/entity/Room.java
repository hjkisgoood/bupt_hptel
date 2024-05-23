package sjk.com.demo.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int currentTemperature;
    private boolean isAirConditionOn;
    private int fanSpeed;
    private int mode; // 0: cooling, 1: heating
    private double dailyRent;
    private int defaultTemperature = 26;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Customer> customers;

}
