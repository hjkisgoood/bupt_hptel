package sjk.com.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "canteens")
public class Canteens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "canteen_id")
    private Long canteenId;

    @Column(name = "university_id")
    private Long universityId;

    @Column(name = "average_meal_price")
    private double averageMealPrice;

    @Column(name = "has_sichuan")
    private boolean hasSichuan;

    @Column(name = "has_shandong")
    private boolean hasShandong;

    @Column(name = "has_guangdong")
    private boolean hasGuangdong;

    // Constructors
    public Canteens() {
    }

    // Getters and Setters
    public Long getCanteenId() {
        return canteenId;
    }

    public void setCanteenId(Long canteenId) {
        this.canteenId = canteenId;
    }

    public Long getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Long universityId) {
        this.universityId = universityId;
    }

    public double getAverageMealPrice() {
        return averageMealPrice;
    }

    public void setAverageMealPrice(double averageMealPrice) {
        this.averageMealPrice = averageMealPrice;
    }

    public boolean isHasSichuan() {
        return hasSichuan;
    }

    public void setHasSichuan(boolean hasSichuan) {
        this.hasSichuan = hasSichuan;
    }

    public boolean isHasShandong() {
        return hasShandong;
    }

    public void setHasShandong(boolean hasShandong) {
        this.hasShandong = hasShandong;
    }

    public boolean isHasGuangdong() {
        return hasGuangdong;
    }

    public void setHasGuangdong(boolean hasGuangdong) {
        this.hasGuangdong = hasGuangdong;
    }
}