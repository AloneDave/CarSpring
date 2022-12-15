package net.hnkj.carspring.model;

import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ToString
public class Car implements Serializable {
    private Integer id;

    private String carname;

    private Float price;

    private Date licenceTime;

    private String city;

    private String brand;

    private String fastens;

    private String gear;

    private String size;

    private String color;

    private String gearbox;

    private String displacement;

    private Integer transfer;

    private Double mileage;

    private String address;

    public Car(Integer id, String carname, Float price, Date licenceTime, String city, String brand, String fastens, String gear, String size, String color, String gearbox, String displacement, Integer transfer, Double mileage, String address) {
        this.id = id;
        this.carname = carname;
        this.price = price;
        this.licenceTime = licenceTime;
        this.city = city;
        this.brand = brand;
        this.fastens = fastens;
        this.gear = gear;
        this.size = size;
        this.color = color;
        this.gearbox = gearbox;
        this.displacement = displacement;
        this.transfer = transfer;
        this.mileage = mileage;
        this.address = address;
    }

    public Car() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getLicenceTime() {
        return licenceTime;
    }

    public void setLicenceTime(Date licenceTime) {
        this.licenceTime = licenceTime;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFastens() {
        return fastens;
    }

    public void setFastens(String fastens) {
        this.fastens = fastens;
    }

    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public Integer getTransfer() {
        return transfer;
    }

    public void setTransfer(Integer transfer) {
        this.transfer = transfer;
    }

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}