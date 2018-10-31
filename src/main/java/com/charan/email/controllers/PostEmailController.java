package com.charan.email.controllers;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Base64;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.charan.email.models.EmailModels;

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
	
	@PostMapping("/sendEmailWithAttachments")
	public String sendEmailWithAttachments(@RequestBody EmailModels emailModels) throws MessagingException {
		MimeMessage mimeMessage = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setBcc(emailModels.getBccTo());
		helper.setTo(emailModels.getSendTo());
		helper.setSubject(emailModels.getSubject());
		helper.setText(emailModels.getTemplate());
		emailModels.getAttachments().forEach(attachment -> {
			try {
				File outputFile = new File(attachment.getName());
				byte[] decodedBytes = Base64.getDecoder().decode(attachment.getFile());
				FileUtils.writeByteArrayToFile(outputFile, decodedBytes);
				helper.addAttachment(attachment.getName(), outputFile);
			} catch(Exception exception) {
				throw new RuntimeException();
			}

		});
		emailSender.send(mimeMessage);
		return "success";
	}

}
