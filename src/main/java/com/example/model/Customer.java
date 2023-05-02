package com.example.model;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Customer {
	private Long cust_id;
	private String username;
	private Long phone;
	private String email;
	private LocalDateTime date;
}
