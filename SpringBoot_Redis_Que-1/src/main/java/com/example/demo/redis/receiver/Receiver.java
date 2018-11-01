package com.example.demo.redis.receiver;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author HouZhiBo
 * @version 创建时间：2018年11月1日 上午9:49:29
 * @ClassName 类名称
 * @Description 类描述
 */
public class Receiver {
	private CountDownLatch latch;

	@Autowired
	public Receiver(CountDownLatch latch) {
		this.latch = latch;
	}

	public void receiveMessage(String message) {
		System.out.println("收到的消息： <" + message + ">");
		latch.countDown();
		System.out.println("发送消息成功： <" + message + ">");
	}
}
