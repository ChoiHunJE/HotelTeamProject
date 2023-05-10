package com.example.service;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import com.example.exception.BusinessReservationException;
import com.example.exception.ExceptionCode;
import com.example.model.mail.Mail;
import com.example.model.mail.ReservationEvent;

import lombok.extern.slf4j.Slf4j;

@Component
@EnableAsync
@Slf4j
public class EventHandler {
	private final EmailService emailService;
	private final ReservationService reservationService;
	
	public EventHandler(EmailService emailService,
						ReservationService reservationService) {
		this.emailService = emailService;
		this.reservationService = reservationService;
	}
	
	@EventListener
	@Async	// 비동기
	public void handleEmailSending(ReservationEvent reservationEvent) {
		//	이메일 전송
		// 	예외 발생 시 처리할 로직 구현 -> DB에서 예약 삭제
		try {
			log.info("메일 전송");
			//	메일 전송 로직 구현
			Mail mail = new Mail();
			mail.setAddress(reservationEvent.getReservation().getEmail());
			mail.setTitle("예약번호 "+ reservationEvent.getReservation().getRes_id() + " 예약이 완료 되었습니다.");
			emailService.sendMail(mail);
			
		} catch (Exception e) {
			log.error("MailSendException happened: ", e);
			
			//	예약 정보 삭제 로직 구현
			reservationService.deleteReservation(reservationEvent.getReservation().getRes_id());
			throw new BusinessReservationException(ExceptionCode.FAILED_TO_RESERVATION);
			
		}
		
	}
}
