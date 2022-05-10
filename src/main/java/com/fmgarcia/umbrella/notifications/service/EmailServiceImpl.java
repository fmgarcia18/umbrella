package com.fmgarcia.umbrella.notifications.service;

import com.fmgarcia.umbrella.notifications.dtos.EmailRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Slf4j
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

            sender.send(message);

            log.info("enviando email " + emailRequest.toString());
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
