package com.rentacar.rentacar.persistence;

import com.rentacar.rentacar.domain.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Page<Reservation> findByCarId(long carId, Pageable pageable);
}
