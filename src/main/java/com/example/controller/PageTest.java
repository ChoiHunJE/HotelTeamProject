package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PageTest {
	
	@GetMapping("/")
	public String getPage() {
		log.info("test 페이지 시작!!");
		return "index";
	}
}
