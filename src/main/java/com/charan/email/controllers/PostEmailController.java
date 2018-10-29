package com.charan.email.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostEmailController {
	
	@Autowired
    public JavaMailSender emailSender;
	
	
	@PostMapping("/sendEmail")
	public String sendEmail(@RequestBody String body){
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo("charantej@mailinator.com");
			message.setSubject("Message from Charan");
			message.setText("Hi Welcome to spring mailer");
			emailSender.send(message);
			return "success";
		} catch(Exception exception) {
			return "failure";
		}
		
	}

}
