package com.example.demo.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author HouZhiBo
 * @version 创建时间：2018年11月1日 上午8:55:28
 * @ClassName 类名称
 * @Description 类描述 消息生产者，注入redisTemplate,用convertAndSend发送消息
 */

@Service
public class PublisherService {

	@Autowired
	private StringRedisTemplate redisTemplate;

	public String sendMessage(String name) {
		try {
			redisTemplate.convertAndSend("TOPIC_USERNAME", name);
			return "消息发送成功了";

		} catch (Exception e) {
			e.printStackTrace();
			return "消息发送失败了";
		}
	}
}
