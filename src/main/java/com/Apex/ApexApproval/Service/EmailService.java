package com.Apex.ApexApproval.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Async
    public void SendEmail(String fromEmail, String toEmail){
        System.out.println("inside java mail sender");
        SimpleMailMessage mail= new SimpleMailMessage();
        mail.setFrom("dharshankkrlb2@gmail.com");
        mail.setTo(toEmail);
        mail.setSubject("New Approval Pending");
        mail.setText("Received a request from "+fromEmail);
        javaMailSender.send(mail);
        System.out.println("Sent the Email Successfully");
    }
}
