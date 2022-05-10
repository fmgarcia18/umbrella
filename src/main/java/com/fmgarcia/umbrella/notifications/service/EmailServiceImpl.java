package com.fmgarcia.umbrella.notifications.service;

import com.fmgarcia.umbrella.notifications.dtos.EmailRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@RequiredArgsConstructor
@Service
public class EmailServiceImpl implements EmailService{

    private final JavaMailSender sender;

    @Override
    public void sendEmail(EmailRequest emailRequest) {

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try{
            helper.setTo(emailRequest.getEmail());
            helper.setText(emailRequest.getContent());
            helper.setSubject(emailRequest.getSubject());
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
