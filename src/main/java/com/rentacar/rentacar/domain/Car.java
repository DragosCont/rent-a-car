package com.rentacar.rentacar.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Car {

    @Id
    @GeneratedValue
    private long id;

    private String category;

    @NotNull
    private String brand;

    private String imageUrl;

    @NotNull
    private double price;

    @NotNull
    private int doorNumber;

    @NotNull
    private int seats;

    @NotNull
    private int luggageNumber;

    @NotNull
    private String transmission;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(int doorNumber) {
        this.doorNumber = doorNumber;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getLuggageNumber() {
        return luggageNumber;
    }

    public void setLuggageNumber(int luggageNumber) {
        this.luggageNumber = luggageNumber;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
