package com.vasu.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class MailSenderUtil {
	
	@Autowired
	private JavaMailSender mailSender;
	
	
	public boolean sendMail(String to,String subject,String body) {
	boolean isSend =false;
	try {
		MimeMessage mimmsg= mailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(mimmsg);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(body, true);
		mailSender.send(mimmsg);
		isSend =true;
	}catch (Exception e){
		e.printStackTrace();	
	}
	return isSend;
	}

}
