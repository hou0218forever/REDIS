package com.example.demo.redis;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author HouZhiBo
 * @version 创建时间：2018年10月31日 下午6:29:55
 * @ClassName 类名称
 * @Description 类描述
 */
public abstract class IRedisService<T> {
	@Autowired
	RedisTemplate<String, Object> redisTemplate;
	@Resource
	HashOperations<String, String, T> hashOperations;

	/**
	 * 获取存入redis中的key
	 */
	protected abstract String getRedisKey();

	/**
	 * 添加键值对信息进hash中
	 * 
	 * @Param key hash键名
	 * @Param domain 对象，类型为Object
	 * @Param expire 过期时间，若为-1则表示不设置时间
	 */
	public void put(String key, T domain, long expire) {
		hashOperations.put(getRedisKey(), key, domain);
		if (expire != -1) {
			redisTemplate.expire(key, expire, TimeUnit.SECONDS);
		}
	}

	/**
	 * 删除对应键名的hash
	 * 
	 * @Param key
	 */
	public void delete(String key) {
		hashOperations.delete(getRedisKey(), key);
	}

	/**
	 * 根据键名key查询redis中该hash中的值
	 */
	public T get(String key) {
		return hashOperations.get(getRedisKey(), key);
	}

	/*
	 * 获取当前redis库中所有对象
	 */
	public List<T> getAll() {
		return hashOperations.values(getRedisKey());
	}

	/**
	 * 查询查询当前redis库下所有key
	 *
	 * @return
	 */
	public Set<String> getKeys() {
		return hashOperations.keys(getRedisKey());
	}

	/**
	 * 判断key是否存在redis中
	 *
	 * @param key 传入key的名称
	 * @return
	 */
	public boolean isKeyExists(String key) {
		return hashOperations.hasKey(getRedisKey(), key);
	}

	/**
	 * 查询当前key下缓存数量 即当前hash下面的键值对数量
	 * 
	 * @return
	 */
	public long count() {
		return hashOperations.size(getRedisKey());
	}

	/**
	 * 清空redis中当前hash的所有键值对
	 */
	public void empty() {
		Set<String> set = getKeys();
		for (String s : set) {
			delete(s);
		}
	}
}
