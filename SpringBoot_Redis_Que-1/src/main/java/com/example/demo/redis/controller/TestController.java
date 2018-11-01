package com.example.demo.redis.controller;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.redis.config.SpringContextHolder;

/**
 * @author HouZhiBo
 * @version 创建时间：2018年11月1日 上午10:46:04
 * @ClassName 类名称
 * @Description 类描述
 */
@RequestMapping("publisher")
@RestController
@Component
public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	@Autowired
	CountDownLatch latch;
	@Autowired
	StringRedisTemplate template;

	//注入bean两种方式：ctx.getBean和@Autowired
	@RequestMapping("{name}")
	public String sendMessage(@PathVariable("name") String name) {
//		ApplicationContext ctx = SpringContextHolder.getApplicationContext();
//		StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);
//		CountDownLatch latch = ctx.getBean(CountDownLatch.class);
		logger.info("我要发送消息咯...");
		try {
			logger.info("消息正在发送...");
			template.convertAndSend("msg", "欢迎使用redis的消息队列!");
			latch.await();
		} catch (InterruptedException e) {
			logger.info("消息发送失败...");
		}
		return "ok";
	}
}
