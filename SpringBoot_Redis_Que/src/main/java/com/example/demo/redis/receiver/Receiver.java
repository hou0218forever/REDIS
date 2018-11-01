package com.example.demo.redis.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

/**
 * @author HouZhiBo
 * @version 创建时间：2018年11月1日 上午8:45:12
 * @ClassName 类名称
 * @Description 类描述
 */

@Component
public class Receiver implements MessageListener {
	private static Logger logger = LoggerFactory.getLogger(Receiver.class);

	@Autowired
	private StringRedisTemplate redisTemplate;

	@Override
	public void onMessage(Message message, byte[] pattern) {
		RedisSerializer<String> valueSerializer = redisTemplate.getStringSerializer();
		String deserialize = valueSerializer.deserialize(message.getBody());
		logger.info("收到的redisQue消息" + deserialize);
	}
}
