package com.example.demo.redis.config;

import java.util.concurrent.CountDownLatch;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import com.example.demo.redis.receiver.Receiver;

/**
 * @author HouZhiBo
 * @version 创建时间：2018年11月1日 上午9:27:59
 * @ClassName 类名称
 * @Description 类描述
 */
@Configuration
@AutoConfigureAfter({ Receiver.class })
public class RedisQueConfig {

	// 必要的redis消息队列连接工厂
	@Bean
	Receiver receiver(CountDownLatch latch) {
		return new Receiver(latch);
	}

	// 必要的redis消息队列连接工厂
	@Bean
	CountDownLatch latch() {
		return new CountDownLatch(1);
	}

	// redis模板
	@Bean
	StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
		return new StringRedisTemplate(connectionFactory);
	}

	// 注入消息监听器容器
	@Bean
	RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter) {
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.addMessageListener(listenerAdapter, new PatternTopic("msg"));
		return container;
	}

	// 注入消息监听器容器
	@Bean
	MessageListenerAdapter listenerAdapter(Receiver receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}
}
