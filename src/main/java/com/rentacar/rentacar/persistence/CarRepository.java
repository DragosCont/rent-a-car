package com.rentacar.rentacar.persistence;

import com.rentacar.rentacar.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
