package com.rentacar.rentacar.web;


import com.rentacar.rentacar.service.ReservationService;
import com.rentacar.rentacar.transfer.SaveReservationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PutMapping
    public ResponseEntity<Void> addNewReservation(@RequestBody @Valid SaveReservationRequest request) {
        reservationService.createReservation(request);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
