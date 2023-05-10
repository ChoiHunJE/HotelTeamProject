package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Room;
import com.example.model.reservation.Customer;
import com.example.model.reservation.Reservation;
import com.example.model.reservation.ReservationDTO;

@Mapper
public interface ReservationMapper extends JpaRepository<Reservation, Long>{
   void saveReservation(Reservation reservation);
   void saveCustomer(Customer customer);
   List<ReservationDTO> searchDTO();
   void saveRoom(Room room);
   void deleteReservation(Long res_id);
   
}