package com.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.model.Mail;


@Service
public class EmailService {
	
	 private final JavaMailSender emailSender;
	 
	 @Value("${GMAIL_ADDRESS}")
	 private static String FROM_ADDRESS;
	 
	 public EmailService(JavaMailSender emailSender) {
		 this.emailSender = emailSender;
	 }
	 
	    public void sendMail(Mail mail) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        
	        message.setFrom(FROM_ADDRESS);	// 이메일 주소
	        message.setTo(mail.getAddress());
	        message.setSubject(String.format("%S 님, 예약이 완료되었습니다.", mail.getAddress()));
	        message.setText(mail.getContent());
	        
	        emailSender.send(message);
	    }
}
