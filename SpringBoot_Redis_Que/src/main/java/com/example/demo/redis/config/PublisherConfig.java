package com.example.demo.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author HouZhiBo
 * @version 创建时间：2018年11月1日 上午8:41:31
 * @ClassName 类名称
 * @Description 类描述 注册redisTemplate，作为消息队列的发布者
 */

@Configuration
public class PublisherConfig {

	@Bean
	public StringRedisTemplate getRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
		return new StringRedisTemplate(redisConnectionFactory);
	}
}
