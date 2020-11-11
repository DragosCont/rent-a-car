package com.rentacar.rentacar.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    private String category;

    @NotNull
    private String brand;

    private String imageUrl;

    @NotNull
    private Double price;

    @NotNull
    private Integer doorNumber;

    @NotNull
    private Integer seats;

    @NotNull
    private Integer luggageNumber;

    @NotNull
    private String transmission;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(Integer doorNumber) {
        this.doorNumber = doorNumber;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Integer getLuggageNumber() {
        return luggageNumber;
    }

    public void setLuggageNumber(Integer luggageNumber) {
        this.luggageNumber = luggageNumber;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", doorNumber=" + doorNumber +
                ", seats=" + seats +
                ", transmission='" + transmission + '\'' +
                ", luggageNumber=" + luggageNumber +
                ", imageUrl='" + imageUrl + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
