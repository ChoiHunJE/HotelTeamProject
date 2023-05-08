package com.example.model.reservation;

import lombok.Data;

@Data
public class ReservationDTO {
   private String email;
   private String username;
   private String phone;
   private String birth;
   private String check_in;
   private String check_out;
   private Long guests;
   private Long room_id;
   private Long res_id;
}