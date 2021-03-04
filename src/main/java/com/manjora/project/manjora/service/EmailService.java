package com.manjora.project.manjora.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

	@Async
	public void sendEmail(String to, String subject, String text) {
		try {
			final MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setFrom("villagrans131799@gmail.com");
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(text, true);

			mailSender.send(message);
		} catch (Exception ex) {
			String error = ex.getMessage();
		}
	}
}
