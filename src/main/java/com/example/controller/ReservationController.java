package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.model.reservation.Customer;
import com.example.model.reservation.Reservation;
import com.example.model.reservation.ReservationDTO;
import com.example.repository.ReservationMapper;

import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.proxy.annotation.Post;

@Slf4j
@Controller
public class ReservationController {
   
   
   // 데이터베이스 접근을 위한 ReservationMapper 필드 선언
   private ReservationMapper reservationMapper;
   
   @Autowired
   public void setReservationMapper(ReservationMapper reservationMapper) {
      this.reservationMapper = reservationMapper;
   }
   
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
      Customer customer = new Customer();
      customer.setUsername(reservationDTO.getUsername());
      customer.setEmail(reservationDTO.getEmail());
      customer.setPhone(reservationDTO.getPhone());
      customer.setBirth(reservationDTO.getBirth());
      reservationMapper.saveCustomer(customer);
      
      reservation.setCheck_in(reservationDTO.getCheck_in());
      reservation.setCheck_out(reservationDTO.getCheck_out());
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
      log.info("나머지 값들 : {}", reservation);
      return "reservation/roomreservation";
   }
   
   @PostMapping("roomreservation")
   public String roomreservation2(@Validated @ModelAttribute("reservationDTO") ReservationDTO reservationDTO) {
      log.info("초기 reservation: {}", reservation);
      reservation.setRoom_id(reservationDTO.getRoom_id());
      log.info("후기 reservation: {}", reservation);
      reservationMapper.saveReservation(reservation);
      reservation = new Reservation();
      return "redirect:/";
   }
}