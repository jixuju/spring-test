package com.superwind.test3rabbitmq;

import com.superwind.test3rabbitmq.service.CallbackSenderService;
import com.superwind.test3rabbitmq.service.DirectSenderService;
import com.superwind.test3rabbitmq.service.FanoutSenderService;
import com.superwind.test3rabbitmq.service.TopicSenderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Test3RabbitmqSenderApplication.class)
public class Test3RabbitmqSenderApplicationTests {

	@Autowired
	private DirectSenderService directSenderService;
	@Autowired
	private TopicSenderService topicSenderService;
	@Autowired
	private FanoutSenderService fanoutSenderService;
	@Autowired
	private CallbackSenderService callbackSenderService;

	@Test
	public void testSendDirect() throws Exception {
		directSenderService.send("message direct");
	}

	@Test
	public void testSendTopic() throws Exception {
		topicSenderService.send("message topicA","topic.A");
		topicSenderService.send("message topicB","topic.B");
	}

	@Test
	public void testSendFanout() throws Exception {
		fanoutSenderService.send("message fanoutA","fanout.A");
		fanoutSenderService.send("message fanoutB","fanout.B");
		fanoutSenderService.send("message fanoutC","fanout.C");
	}

	@Test
	public void testSendCallback() throws Exception {
		callbackSenderService.send("message topicA","topic.A");
	}

}
