package com.example.model.reservation;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Customer {
   private String email;
   private String username;
   private String phone;
   private Long age;
   
}