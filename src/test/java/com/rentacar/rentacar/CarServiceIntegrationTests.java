package com.rentacar.rentacar;

import com.rentacar.rentacar.domain.Car;
import com.rentacar.rentacar.exception.ResourceNotFoundException;
import com.rentacar.rentacar.service.CarService;
import com.rentacar.rentacar.transfer.SaveCarRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.TransactionSystemException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

@SpringBootTest
public class CarServiceIntegrationTests {

    @Autowired
    private CarService carService;

    @Test
    public void addNewCar_whenValidRequest_thenReturnAddedCar(){
        createCar();
    }


    @Test
    public void addNewCar_whenMissingMandatoryInfo_thenThrowException(){
        SaveCarRequest request = new SaveCarRequest();
        request.setCategory("Van - Test");
        request.setBrand(null);
        request.setImageUrl("Test2");
        request.setPrice(15);
        request.setDoorNumber(5);
        request.setSeats(7);
        request.setLuggageNumber(7);
        request.setTransmission("M");

        Exception exception = null;

        try {
            carService.addNewCar(request);
        } catch (Exception e) {
            exception = e;
        }
        assertThat(exception, notNullValue());
        assertThat("Unexpected exception type.", exception instanceof TransactionSystemException);

    }

    @Test
    public void getCar_whenExistingCar_thenReturnCar() {
        Car createdCar = createCar();

        Car carResponse = carService.getCar(createdCar.getId());

        assertThat(carResponse, notNullValue());
        assertThat(carResponse.getId(), is(createdCar.getId()));
        assertThat(carResponse.getCategory(), is(createdCar.getCategory()));
        assertThat(carResponse.getBrand(), is(createdCar.getBrand()));
        assertThat(carResponse.getPrice(), is(createdCar.getPrice()));
        assertThat(carResponse.getDoorNumber(), is(createdCar.getDoorNumber()));
        assertThat(carResponse.getSeats(), is(createdCar.getSeats()));
        assertThat(carResponse.getLuggageNumber(), is(createdCar.getLuggageNumber()));
        assertThat(carResponse.getTransmission(), is(createdCar.getTransmission()));
    }

    @Test
    public void getCar_whenNonExistingCar_thenThrowResourceNotFoundException() {

        Assertions.assertThrows(ResourceNotFoundException.class,
                () -> carService.getCar(99999999));
    }


    private Car createCar() {
        SaveCarRequest request = new SaveCarRequest();
        request.setCategory("Break - Test");
        request.setBrand("Ford Focus - Test");
        request.setImageUrl("Test");
        request.setPrice(19.50);
        request.setDoorNumber(5);
        request.setSeats(5);
        request.setLuggageNumber(5);
        request.setTransmission("M");

        Car car = carService.addNewCar(request);

        assertThat(car, notNullValue());
        assertThat(car.getId(), greaterThan(0L));
        assertThat(car.getCategory(), is(request.getCategory()));
        assertThat(car.getBrand(), is(request.getBrand()));
        assertThat(car.getImageUrl(), is(request.getImageUrl()));
        assertThat(car.getPrice(), is(request.getPrice()));
        assertThat(car.getDoorNumber(), is(request.getDoorNumber()));
        assertThat(car.getSeats(), is(request.getSeats()));
        assertThat(car.getLuggageNumber(), is(request.getLuggageNumber()));
        assertThat(car.getTransmission(), is(request.getTransmission()));

        return car;
    }
}
