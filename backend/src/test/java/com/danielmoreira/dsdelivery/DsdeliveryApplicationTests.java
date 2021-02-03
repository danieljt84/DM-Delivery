package com.danielmoreira.dsdelivery;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.danielmoreira.dsdelivery.model.Mail;
import com.danielmoreira.dsdelivery.services.EmailSendService;

import lombok.extern.log4j.Log4j2;



@SpringBootTest
@Log4j2
class DsdeliveryApplicationTests {
	
	@Autowired
	EmailSendService senderService;

	@Test
	void contextLoads() throws IOException, MessagingException {
		log.info("sending sample email");

		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("name", "John Michel!");
		properties.put("location", "Sri Lanka");
		properties.put("sign", "Java Developer");

		Mail mail = Mail.builder()
				.from("danieljt84@gmail.com")
				.to("danieljt84@gmail.com")
				.htmlTemplate(new Mail.HtmlTemplate("sample", properties))
				.subject("This is sample email with spring boot and thymeleaf")
				.build();

		senderService.sendEmail(mail);
	}

}
