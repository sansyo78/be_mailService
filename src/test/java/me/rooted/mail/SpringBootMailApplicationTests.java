package me.rooted.mail;

import java.io.IOException;

import javax.mail.MessagingException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootMailApplicationTests {

	@Autowired
	CustomMailSender customMailSender;
	
	@Test
	void sendMail() throws MessagingException, IOException {
		customMailSender.sendMail();
	}

}
