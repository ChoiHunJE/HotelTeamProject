package com.example.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.model.Mail;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmailService {
	 private JavaMailSender emailSender;
	 
	    public void sendSimpleMessage(Mail mail) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom("");
	        message.setTo(mail.getAddress());
	        message.setSubject(mail.getTitle());
	        message.setText(mail.getContent());
	        emailSender.send(message);
	    }
}
