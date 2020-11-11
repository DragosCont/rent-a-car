package com.rentacar.rentacar.transfer;

import javax.validation.constraints.NotNull;

public class SaveReservationRequest {

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

    private long CarId;

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

    public long getCarId() {
        return CarId;
    }

    public void setCarId(long carId) {
        CarId = carId;
    }

    @Override
    public String toString() {
        return "SaveUserRequest{" +
                "pickUpLocation='" + pickUpLocation + '\'' +
                ", returnLocation='" + returnLocation + '\'' +
                ", pickupDateAndTime='" + pickupDateAndTime + '\'' +
                ", returnDateAndTime='" + returnDateAndTime + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", CarId=" + CarId +
                '}';
    }
}
