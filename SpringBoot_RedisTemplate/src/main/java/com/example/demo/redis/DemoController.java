package com.example.demo.redis;

/**
* @author HouZhiBo
* @version 创建时间：2018年10月31日 下午6:10:52
* @ClassName 类名称
* @Description 类描述
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@Autowired
	private RedisService redisService;

	@RequestMapping(value = "/set", method = RequestMethod.POST)
	public String demoTest() {
		boolean set = redisService.set("1", "value22222");
		if (set) {
			return "ok";
		}
		return "false";
	}

	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public String getTest() {
		return redisService.get("1").toString();
	}

}
