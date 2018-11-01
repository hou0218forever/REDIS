package com.example.demo.redis.controller;

import java.util.concurrent.CountDownLatch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.demo.SpringBootRedisQue1Application;
 
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootRedisQue1Application.class)
public class MsgQueueTest {
	@Autowired
	protected ApplicationContext ctx;
	private static final Logger logger = LoggerFactory.getLogger(MsgQueueTest.class);

	@Test
	public void SendMsg() {
		StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);
		CountDownLatch latch = ctx.getBean(CountDownLatch.class);
		logger.info("我要发送消息咯...");
		template.convertAndSend("msg", "欢迎使用redis的消息队列!");
		try {
			logger.info("消息正在发送...");
			latch.await();
		} catch (InterruptedException e) {
			logger.info("消息发送失败...");
		}
	}

}
