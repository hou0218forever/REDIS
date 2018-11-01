package com.example.demo.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.redis.service.PublisherService;

/**
 * @author HouZhiBo
 * @version 创建时间：2018年11月1日 上午9:05:40
 * @ClassName 类名称
 * @Description 类描述
 */
@RestController
@RequestMapping("publisher")
public class PublisherController {

	@Autowired
	private PublisherService publisherService;

	@RequestMapping("{name}")
	public String sendMessage(@PathVariable("name") String name) {
		for(int i=0;i<10;i++) {
			 publisherService.sendMessage(name+i);
		}
		return "ok";
	}
}
