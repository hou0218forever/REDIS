package com.example.demo.redis;

import org.springframework.stereotype.Service;

/**
 * @author HouZhiBo
 * @version 创建时间：2018年10月31日 下午6:31:02
 * @ClassName 类名称
 * @Description 类描述
 */
@Service
public class IRedisServiceImpl extends IRedisService<RedisModel> {
	private static final String REDIS_KEY = "TEST_REDIS_KEY";

	@Override
	public String getRedisKey() {
		return REDIS_KEY;
	}
}
