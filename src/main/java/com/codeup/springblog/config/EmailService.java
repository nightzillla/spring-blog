package com.codeup.springblog.config;

import com.codeup.springblog.models.User;
import net.bytebuddy.build.Plugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailService")
public class EmailService {

    @Autowired
    public JavaMailSender emailSender;
    @Value("${spring.mail.from}")
    private String from;

    public void prepareAndSent(User user, String subject, String body){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(user.getEmail());
        msg.setFrom(from);
        msg.setSubject(subject);
        msg.setText(body);

        try{
            this.emailSender.send(msg);
        } catch (MailParseException mex) {
            System.out.println(mex.getMessage());
        }
    }

}
