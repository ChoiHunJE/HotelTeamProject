package com.example.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.model.mail.Mail;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class EmailService {
	
	 private final JavaMailSender mailSender;
	 
	 public EmailService(JavaMailSender mailSender) {
		 this.mailSender = mailSender;
	 }
	 
	 public void sendSimpleMessage(Mail mail) {
		 SimpleMailMessage message = new SimpleMailMessage();
		 message.setTo(mail.getAddress());
		 log.info("address: {}", mail.getAddress());
		 message.setSubject(mail.getTitle());
		 message.setText(mail.getContent());
		 mailSender.send(message);
	 }
	 
}
