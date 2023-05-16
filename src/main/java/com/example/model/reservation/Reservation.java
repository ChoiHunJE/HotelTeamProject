package com.example.model.reservation;


import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Reservation {
   private Long res_id;
   private String check_in;
   private String check_out;
   private Long guests;
   private String email;
   private Long room_id;
}