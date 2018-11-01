package com.example.demo.redis;
/**
* @author HouZhiBo
* @version 创建时间：2018年10月31日 下午4:28:17
* @ClassName 类名称
* @Description 类描述
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/redis")
@RestController
public class RedisController {
	@Autowired
	private RedisClient redisClient;

	@RequestMapping("/set")
	public String set(String key, String value) throws Exception {
		redisClient.set(key, value);
		return "yes";
	}

	@RequestMapping("/get")
	public String get(String key) throws Exception {
		return redisClient.get(key);
	}

	@RequestMapping("/del")
	public String del(String key) throws Exception {
		return redisClient.delete(key).toString();
	}

}
