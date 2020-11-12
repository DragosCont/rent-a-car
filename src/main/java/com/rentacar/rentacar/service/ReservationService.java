package com.rentacar.rentacar.service;

import com.rentacar.rentacar.domain.Car;
import com.rentacar.rentacar.domain.Reservation;
import com.rentacar.rentacar.persistence.ReservationRepository;
import com.rentacar.rentacar.transfer.SaveReservationRequest;
import com.rentacar.rentacar.transfer.ReservationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ReservationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationService.class);


    private final ReservationRepository reservationRepository;
    private final CarService carService;

   @Autowired
    public ReservationService(ReservationRepository reservationRepository, CarService carService) {
        this.reservationRepository = reservationRepository;
        this.carService = carService;
   }


   @Transactional
    public ReservationResponse createReservation (SaveReservationRequest request) {
        LOGGER.info("Creating reservation: {}", request);

        Car car = carService.getCar(request.getCarId());

        Reservation reservation = new Reservation();
        reservation.setPickUpLocation(request.getPickUpLocation());
        reservation.setReturnLocation(request.getReturnLocation());
        reservation.setPickupDateAndTime(request.getPickupDateAndTime());
        reservation.setReturnDateAndTime(request.getReturnDateAndTime());
        reservation.setName(request.getName());
        reservation.setEmail(request.getEmail());
        reservation.setPhoneNumber(request.getPhoneNumber());
        reservation.setCar(car);

        Reservation savedReservation = reservationRepository.save(reservation);

        return mapReservationResponse(savedReservation);
    }


    private ReservationResponse mapReservationResponse(Reservation reservation) {
        ReservationResponse response = new ReservationResponse();

        response.setId(reservation.getId());
        response.setPickUpLocation(reservation.getPickUpLocation());
        response.setReturnLocation(reservation.getReturnLocation());
        response.setPickupDateAndTime(reservation.getPickupDateAndTime());
        response.setReturnDateAndTime(reservation.getReturnDateAndTime());
        response.setName(reservation.getName());
        response.setEmail(reservation.getEmail());
        response.setPhoneNumber(reservation.getPhoneNumber());

        return response;
    }
}
