package com.example.demo.redis;

import java.io.Serializable;

/**
 * @author HouZhiBo
 * @version 创建时间：2018年10月31日 下午6:29:18
 * @ClassName 类名称
 * @Description 类描述
 */
public class RedisModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1296757375636813583L;
	private String redisKey;
	private String name;
	private String tel;
	private String address;

	/*
	 * getter and setter
	 */
	public String getRedisKey() {
		return redisKey;
	}

	public void setRedisKey(String redisKey) {
		this.redisKey = redisKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
