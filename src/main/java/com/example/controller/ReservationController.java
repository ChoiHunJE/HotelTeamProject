package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ReservationController {
	
	//예약하기 페이지 이동
	@GetMapping("reservation")
	public String Reservation() {
		log.info("reservation 실행!!");
		return "reservation/reservation";
	}
}
