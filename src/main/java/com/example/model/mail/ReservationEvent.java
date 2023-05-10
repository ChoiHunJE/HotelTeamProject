package com.example.model.mail;


import com.example.model.reservation.Reservation;

import lombok.Getter;

@Getter
public class ReservationEvent {
	private Reservation reservation;

	public ReservationEvent(Reservation reservation) {
		this.reservation = reservation;
	}
}
