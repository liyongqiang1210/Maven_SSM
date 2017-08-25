package com.timer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时器
 * @author Li Yongqiang
 *
 */
@Component
public class TimerTask {
	/**
	 * 每天22点30启动任务
	 */
	@Scheduled(cron = "0 */5 * * * ?")
	public void test1() {
		System.out.println("我是定时任务，我5分钟执行一次");
	}

	@Scheduled(cron = "0/5 * * * * ?") // 每隔5秒隔行一次
	public void test2() {
		System.out.println("我是定时任务，我5秒执行一次");
	}
}