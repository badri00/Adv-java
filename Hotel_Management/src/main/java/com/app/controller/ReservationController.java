package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ReservationDto;
import com.app.service.ReservationService;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
	@Autowired
    private ReservationService reservationService;

	@PostMapping
	public ResponseEntity<?>createNewReservation(@RequestBody ReservationDto reservationDto){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.createNewReservation(reservationDto));
		
	}
	
}
