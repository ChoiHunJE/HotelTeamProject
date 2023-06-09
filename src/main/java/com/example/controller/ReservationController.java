package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.model.mail.Mail;
import com.example.model.reservation.Customer;
import com.example.model.reservation.Reservation;
import com.example.model.reservation.ReservationDTO;
import com.example.repository.ReservationMapper;
import com.example.service.EmailService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ReservationController {
   
   
   // 데이터베이스 접근을 위한 ReservationMapper 필드 선언
   private ReservationMapper reservationMapper;
   private final EmailService emailService;
  
   @Autowired
   public void setReservationMapper(ReservationMapper reservationMapper) {
      this.reservationMapper = reservationMapper;
   }
   
   public ReservationController(EmailService emailService) {
		this.emailService = emailService;
	}
   Customer customer = new Customer();
   Reservation reservation = new Reservation();
   
   
   // 예약하기 페이지 이동
   @GetMapping("reservation")
   public String ReservationForm(Model model) {
      log.info("reservation 실행!!");
      ReservationDTO reservationDTO = new ReservationDTO();
      model.addAttribute("reservationDTO", reservationDTO);
      
      return "reservation/reservation";
   }
   
   // reservation 저장
   @PostMapping("reservation")
   public String reservation(@Validated @ModelAttribute("reservationDTO") ReservationDTO reservationDTO) {
      log.info("reservationDTO: {}", reservationDTO);
      customer.setUsername(reservationDTO.getUsername());
      customer.setEmail(reservationDTO.getEmail());
      customer.setPhone(reservationDTO.getPhone());
      customer.setAge(reservationDTO.getAge());
      reservationMapper.saveCustomer(customer);
      
      reservation.setGuests(reservationDTO.getGuests());
      reservation.setEmail(reservationDTO.getEmail());
      
      log.info("reservation: {}", reservation);
      
      return "redirect:/roomreservation";
   }
   
   @GetMapping("roomreservation")
   public String roomreservation(Model model) {
      log.info("roomreservation 실행!!");
      ReservationDTO reservationDTO =  new ReservationDTO();
      model.addAttribute("reservationDTO", reservationDTO);
      List<Reservation> reservations = reservationMapper.findReservation();
      model.addAttribute("reservations", reservations);
      log.info("reservations: {}", reservations);
      
      
      return "reservation/roomreservation";
   }
   
   @PostMapping("roomreservation")
   public String roomreservation2(@ModelAttribute("reservationDTO") ReservationDTO reservationDTO
		   						  ,Mail mail) {
	   
	   reservation.setCheck_in(reservationDTO.getCheck_in());
	   reservation.setCheck_out(reservationDTO.getCheck_out());
      log.info("초기 reservation: {}", reservation);
      reservation.setRoom_id(reservationDTO.getRoom_id());
      log.info("후기 reservation: {}", reservation);
      reservationMapper.saveReservation(reservation);
      
      mail.setAddress(reservation.getEmail());
      mail.setTitle(customer.getUsername()+ " 님 예약이 완료되었습니다.");
      mail.setContent("예약번호: " + reservation.getRes_id() + "\n" 
      + "체크인: " + reservation.getCheck_in() + "\n" 
      + "체크아웃: " + reservation.getCheck_out());
      
      emailService.sendSimpleMessage(mail);

      return "redirect:/";
   }
}