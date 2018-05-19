package com.superwind.test8zookeeper;

import com.superwind.service.ZookeeperService;
import org.apache.zookeeper.KeeperException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test8ZookeeperApplicationTests {
	@Test
	public void contextLoads() {
	}

	@Test
	public void testZookeeper() throws IOException, KeeperException, InterruptedException {
		ZookeeperService zookeeperService = new ZookeeperService();
		zookeeperService.createZKInstance();
		zookeeperService.ZKOperations();
		zookeeperService.ZKClose();
	}
}
