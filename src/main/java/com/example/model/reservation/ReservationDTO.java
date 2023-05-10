package com.example.model.reservation;

import lombok.Data;

@Data
public class ReservationDTO {
   private String email;
   private String username;
   private String phone;
   private Long age;
   private String check_in;
   private String check_out;
   private Long guests;
   private Long room_id;
   private Long res_id;
}