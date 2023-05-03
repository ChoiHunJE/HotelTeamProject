package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.model.Mail;
import com.example.service.EmailService;

@Controller
public class MainController {
	private final EmailService emailService;
	 
    public MainController(EmailService emailService) {
        this.emailService = emailService;
    }
 
    @GetMapping("/mail/send")
    public String main() {
        
    	return "sendMail";
    }
 
    @PostMapping("/mail/send")
    public String sendMail(Mail mail) {
        emailService.sendSimpleMessage(mail);
        System.out.println("메일 전송 완료!");
        
        return "redirect:/";
    }
}
