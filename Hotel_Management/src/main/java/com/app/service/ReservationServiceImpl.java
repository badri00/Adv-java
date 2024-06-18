package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ReservationDto;
import com.app.entities.Reservation;
import com.app.repository.ReservationRepo;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	private ReservationRepo reservationRepo;
@Autowired
private ModelMapper modelMapper;
	
@Override
	public ReservationDto createNewReservation(ReservationDto reservationDto) {
        Reservation reservation=modelMapper.map(reservationDto, Reservation.class);
        Reservation reservation1=reservationRepo.save(reservation);
        return modelMapper.map(reservation1, ReservationDto.class);
		
	}

}
