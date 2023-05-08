package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.ReservationEvent;
import com.example.model.reservation.Reservation;
import com.example.repository.ReservationMapper;

@Service
@Transactional
public class ReservationService {
	
	
	private final ReservationMapper reservationMapper;
	
	private final ApplicationEventPublisher applicationEventPublisher;
	
	public ReservationService(ReservationMapper reservationMapper,
							  ApplicationEventPublisher applicationEventPublisher) {
		this.reservationMapper = reservationMapper;
		this.applicationEventPublisher = applicationEventPublisher;
	}
	
	public Reservation createReservation(Reservation reservation) {
		
		Reservation saveReservation = reservationMapper.saveReservation(reservation);
		
		// 이벤트 발생을 어플리케이션에게 알린다.
		applicationEventPublisher.publishEvent(new ReservationEvent(saveReservation));
		
		return saveReservation;
	}
	
	public void deleteReservation(long res_id) {
		
		Reservation deleteReservation = reservationMapper.deleteReservation(res_id);
		
	}
	
}
