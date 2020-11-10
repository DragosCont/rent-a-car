package com.rentacar.rentacar.service;

import com.rentacar.rentacar.domain.Car;
import com.rentacar.rentacar.exception.ResourceNotFoundException;
import com.rentacar.rentacar.persistence.CarRepository;
import com.rentacar.rentacar.transfer.SaveCarRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarService.class);

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    public Car addNewCar(SaveCarRequest request) {
        LOGGER.info("Adding new car into database with the details below: {}", request);

        Car car = new Car();
        car.setCategory(request.getCategory());
        car.setBrand(request.getBrand());
        car.setImageUrl(request.getImageUrl());
        car.setPrice(request.getPrice());
        car.setDoorNumber(request.getDoorNumber());
        car.setSeats(request.getSeats());
        car.setLuggageNumber(request.getLuggageNumber());
        car.setTransmission(request.getTransmission());

        return carRepository.save(car);
    }

    public Car getCar(long id) {
        LOGGER.info("Retrieving car {}", id);

        return carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car with id: " + id + " does not exist"));
    }

    public Page<Car> getCars(Pageable pageable) {
        LOGGER.info("Retrieving cars");

        return carRepository.findAll(pageable);
    }

    public Car updateCar(long id, SaveCarRequest request) {
        LOGGER.info("Updating car {}: {}", id, request);

        Car existingCar = getCar(id);

        BeanUtils.copyProperties(request, existingCar);

        return carRepository.save(existingCar);
    }

    public void deleteCar(long id) {
        LOGGER.info("Deleting car {}", id);

        carRepository.deleteById(id);
    }
}
