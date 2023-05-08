package com.example.model;

import lombok.Getter;

@Getter
public class ReservationEvent {
	private Reservation reservation;

	public ReservationEvent(Reservation reservation) {
		this.reservation = reservation;
	}
}
