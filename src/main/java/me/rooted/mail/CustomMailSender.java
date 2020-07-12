package me.rooted.mail;

import java.io.IOException;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Component
public class CustomMailSender {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private SpringTemplateEngine templateEngine;
	
	public void sendMail() throws MessagingException, IOException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
		   
        //메일 제목 설정
        helper.setSubject("ID 신청");
        //수신자 설정
        helper.setTo("sansyo78@gmail.com");
        //템플릿에 전달할 데이터 설정
        Context context = new Context();
        context.setVariable("name", "박상영");
        context.setVariable("id", "X0116762");
        context.setVariable("re", "ID 권한 신청합니다.");
        
        context.setVariable("test_key", "test_value");
        //메일 내용 설정 : 템플릿 프로세스
        String html = templateEngine.process("mail-template",context);
        helper.setText(html, true);
        
        //메일 보내기
        javaMailSender.send(message);
	}
}
