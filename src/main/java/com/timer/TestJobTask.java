package com.timer;

public class TestJobTask {

		/**
		 * 业务逻辑处理
		 */
		public static void service() {
			/** 业务逻辑 */
			System.out.println("定时任务调用成功："+System.currentTimeMillis());
		}
		
		public static void main(String[] args) {
			System.out.println("调用main方法成功");
		}
	
}
