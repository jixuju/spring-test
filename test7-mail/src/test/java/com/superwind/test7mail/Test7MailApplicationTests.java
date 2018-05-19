package com.superwind.test7mail;

import com.superwind.Test7MailApplication;
import com.superwind.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test7MailApplicationTests {
	@Autowired
	private MailService mailService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testSendMessage() {
		mailService.sendMessage("lisi@qq.com","test");
	}

}
