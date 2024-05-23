package sjk.com.demo.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int accumulatedStayTime;
    private double rent;
    private double airConditionFee;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Bill> bills;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

}
