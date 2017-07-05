package com.superwind.test3rabbitmq;

import com.superwind.test3rabbitmq.service.SenderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Test3RabbitmqSenderApplication.class)
public class Test3RabbitmqSenderApplicationTests {

	@Autowired
	private SenderService senderService;

	@Test
	public void send() throws Exception {
		senderService.send("test");
	}

}
