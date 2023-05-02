package com.example.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Reservation {
	private Long res_id;
	private Long cust_id;
	private LocalDateTime check_in;
	private LocalDateTime check_out;
	private Long capacity;
}
