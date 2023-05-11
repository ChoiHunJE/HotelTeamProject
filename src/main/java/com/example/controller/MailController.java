package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.model.mail.Mail;
import com.example.service.EmailService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MailController {
	
	private final EmailService emailService;
	
	public MailController(EmailService emailService) {
		this.emailService = emailService;
	}
	
	@GetMapping("/mail/send")
	public String main() {
		return "sendMail";
	}
	
	@PostMapping("/mail/send")
	public String sendMail(Mail mail) {
		emailService.sendSimpleMessage(mail);
		log.info("Mail Success!!");
		
		return "redirect:/";
	}
}
