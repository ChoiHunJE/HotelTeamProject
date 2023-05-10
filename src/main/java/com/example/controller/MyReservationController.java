package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.model.reservation.Reservation;
import com.example.model.reservation.ReservationDTO;
import com.example.repository.ReservationMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MyReservationController {
   
      // 데이터베이스 접근을 위한 ReservationMapper 필드 선언
      private ReservationMapper reservationMapper;
      
      @Autowired
      public void setReservationMapper(ReservationMapper reservationMapper) {
         this.reservationMapper = reservationMapper;
      }
      
      Reservation reservation = new Reservation();
      
      
      // 예약조회 페이지 이동
      @GetMapping("myreservation1")
      public String ReservationForm(Model model) {
         log.info("myreservation1 실행!!");
          ReservationDTO reservationDTO = new ReservationDTO();
          model.addAttribute("reservationDTO", reservationDTO);
          return "reservation/myreservation1";
      }
      
      // 예약 리스트 보기
       @GetMapping("myreservation2")
       public String list(Model model) {
          log.info("myreservation1 실행!!");
          ReservationDTO reservationDTO = new ReservationDTO();
          model.addAttribute("reservationDTO", reservationDTO);
           return "reservation/myreservation2";
       }
}
       