package com.rentacar.rentacar.transfer;

import javax.validation.constraints.NotNull;

public class SaveCarRequest {

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

    public int getLuggageNumber() {
        return luggageNumber;
    }

    public void setLuggageNumber(int luggageNumber) {
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
        return "AddNewCarRequest{" +
                "category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", price=" + price +
                ", doorNumber=" + doorNumber +
                ", seats=" + seats +
                ", luggageNumber=" + luggageNumber +
                ", transmission='" + transmission + '\'' +
                '}';
    }
}
