package com.example.demo.redis.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
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
public class SubscriberConfig {

	/**
	 * 消息监听适配器，注入接受消息方法，输入方法名字 反射方法
	 *
	 * @param receiver
	 * @return
	 */
	@Bean
	public MessageListenerAdapter getMessageListenerAdapter(Receiver receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage"); // 当没有继承MessageListener时需要写方法名字
	}

	/**
	 * 创建消息监听容器
	 *
	 * @param redisConnectionFactory
	 * @param messageListenerAdapter
	 * @return
	 */
	@Bean
	public RedisMessageListenerContainer getRedisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory,
			MessageListenerAdapter messageListenerAdapter) {
		RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
		redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
		redisMessageListenerContainer.addMessageListener(messageListenerAdapter, new PatternTopic("TOPIC_USERNAME"));
		return redisMessageListenerContainer;
	}
}
