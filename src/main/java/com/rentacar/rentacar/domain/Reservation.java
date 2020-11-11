package com.rentacar.rentacar.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Reservation {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String pickUpLocation;

    @NotNull
    private String returnLocation;

    @NotNull
    private String pickupDateAndTime;

    @NotNull
    private String returnDateAndTime;

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public String getReturnLocation() {
        return returnLocation;
    }

    public void setReturnLocation(String returnLocation) {
        this.returnLocation = returnLocation;
    }

    public String getPickupDateAndTime() {
        return pickupDateAndTime;
    }

    public void setPickupDateAndTime(String pickupDateAndTime) {
        this.pickupDateAndTime = pickupDateAndTime;
    }

    public String getReturnDateAndTime() {
        return returnDateAndTime;
    }

    public void setReturnDateAndTime(String returnDateAndTime) {
        this.returnDateAndTime = returnDateAndTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", pickUpLocation='" + pickUpLocation + '\'' +
                ", returnLocation='" + returnLocation + '\'' +
                ", pickupDateAndTime='" + pickupDateAndTime + '\'' +
                ", returnDateAndTime='" + returnDateAndTime + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation user = (Reservation) o;

        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
