package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.model.Room;
import com.example.model.reservation.Customer;
import com.example.model.reservation.Reservation;
import com.example.model.reservation.ReservationDTO;


@Mapper
public interface ReservationMapper {
   void saveReservation(Reservation reservation);
   void saveCustomer(Customer customer);
   List<ReservationDTO> searchDTO();
   Reservation deleteReservation(Long res_id);
   
}