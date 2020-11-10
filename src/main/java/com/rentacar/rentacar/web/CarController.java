package com.rentacar.rentacar.web;


import com.rentacar.rentacar.domain.Car;
import com.rentacar.rentacar.service.CarService;
import com.rentacar.rentacar.transfer.SaveCarRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public ResponseEntity<Car> addNewCar(@RequestBody @Valid SaveCarRequest request) {
        Car car = carService.addNewCar(request);
        return new ResponseEntity<>(car, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCar(@PathVariable long id) {
        Car car = carService.getCar(id);
        return ResponseEntity.ok(car);
    }

    @GetMapping
    public ResponseEntity<Page<Car>> getCars(Pageable pageable) {
        Page<Car> cars = carService.getCars(pageable);
        return ResponseEntity.ok(cars);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable long id, @RequestBody @Valid SaveCarRequest request) {
        Car car = carService.updateCar(id, request);
        return ResponseEntity.ok(car);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable long id) {
        carService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}