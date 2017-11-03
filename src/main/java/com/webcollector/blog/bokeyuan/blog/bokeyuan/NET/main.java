package com.webcollector.blog.bokeyuan.NET;

public class main {

	public static void main(String[] args) throws Exception {
		Crawler_aspnet cs =new Crawler_aspnet("crawl", true);
		cs.setThreads(1);
		cs.setTopN(100);
		cs.start(2);
		Crawler_beginner cr =new Crawler_beginner("crawl", true);
		cr.setThreads(1);
		cr.setTopN(100);
		cr.start(2);
		Crawler_csharp cs1 =new Crawler_csharp("crawl", true);
		cs1.setThreads(1);
		cs1.setTopN(100);
		cs1.start(2);
		Crawler_dotnetcore cs11 =new Crawler_dotnetcore("crawl", true);
		cs11.setThreads(1);
		cs11.setTopN(100);
		cs11.start(2);
		Crawler_winform cs111 =new Crawler_winform("crawl", true);
		cs111.setThreads(1);
		cs111.setTopN(100);
		cs111.start(2);
	}
}
