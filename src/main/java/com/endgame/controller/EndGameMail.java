package com.endgame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("endgameEmail")
public class EndGameMail {

    @Autowired
    JavaMailSender endGameEmail;

    public String endGameReadyToSendEmail(String toAddress, String fromAddress, String subject, String msgBody) {

        SimpleMailMessage endgameMsg = new SimpleMailMessage();
        endgameMsg.setFrom(fromAddress);
        endgameMsg.setTo(toAddress);
        endgameMsg.setSubject(subject);
        endgameMsg.setText(msgBody);
        endGameEmail.send(endgameMsg);
        return "OK";
    }
}
