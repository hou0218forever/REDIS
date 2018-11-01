package com.example.demo.redis;
/**
* @author HouZhiBo
* @version 创建时间：2018年10月31日 下午4:22:46
* @ClassName 类名称
* @Description 类描述
*/

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisClient {

	private JedisPool jedisPool;

	public void set(String key, String value) throws Exception {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.set(key, value);
		} finally {
			// 返还到连接池
			if (jedis != null) {
				jedis.close();
			}
		}
	}

	public String get(String key) throws Exception {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.get(key);
		} finally {
			// 返还到连接池
			if (jedis != null) {
				jedis.close();
			}
		}
	}

	public Long delete(String key) throws Exception {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.del(key);
		} finally {
			// 返还到连接池
			if (jedis != null) {
				jedis.close();
			}
		}
	}

	public JedisPool getJedisPool() {
		return jedisPool;
	}

	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}

}
