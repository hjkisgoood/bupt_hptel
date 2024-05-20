package sjk.com.demo.entity;
// Universities.java

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Universities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long universityID;

    private String name;
    private String type;
    private double campusArea;
    private double minFee;
    private double maxFee;
    private String province;
    private String city;
    private String address;
    private String climate;
    private String applicationDeadline;

    // 构造函数
    public Universities() {
    }

    // Getter 和 Setter 方法
    public Long getUniversityID() {
        return universityID;
    }

    public void setUniversityID(Long universityID) {
        this.universityID = universityID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCampusArea() {
        return campusArea;
    }

    public void setCampusArea(double campusArea) {
        this.campusArea = campusArea;
    }

    public double getMinFee() {
        return minFee;
    }

    public void setMinFee(double minFee) {
        this.minFee = minFee;
    }

    public double getMaxFee() {
        return maxFee;
    }

    public void setMaxFee(double maxFee) {
        this.maxFee = maxFee;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getApplicationDeadline() {
        return applicationDeadline;
    }

    public void setApplicationDeadline(String applicationDeadline) {
        this.applicationDeadline = applicationDeadline;
    }



}
