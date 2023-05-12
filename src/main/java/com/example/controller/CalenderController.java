package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalenderController {

	@GetMapping("calender")
	public String CalenderView() {
		
		return "calender";
	}
	
}
