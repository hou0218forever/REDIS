package com.example.demo.redis;
/**
* @author HouZhiBo
* @version 创建时间：2018年10月31日 下午4:20:57
* @ClassName 类名称
* @Description 类描述
*/

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = JedisProperties.JEDIS_PREFIX)
public class JedisProperties {

	public static final String JEDIS_PREFIX = "jedis";

	private String host;

	private int port;

	private String password;

	private int maxTotal;

	private int maxIdle;

	private int maxWaitMillis;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getMaxTotal() {
		return maxTotal;
	}

	public void setMaxTotal(int maxTotal) {
		this.maxTotal = maxTotal;
	}

	public int getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}

	public int getMaxWaitMillis() {
		return maxWaitMillis;
	}

	public void setMaxWaitMillis(int maxWaitMillis) {
		this.maxWaitMillis = maxWaitMillis;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
