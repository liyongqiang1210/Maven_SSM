package com.webcollector.other;

import java.io.IOException;

import javax.print.Doc;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

public class HotSong extends BreadthCrawler {

	private String url = "http://music.baidu.com/top";
	private String urlRegex = ".*top.*";
	private String songRegex = ".*\\/song\\/\\d{8,11}";
	public HotSong(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		// TODO Auto-generated constructor stub
		this.addSeed(url);
	}

	public void visit(Page page, CrawlDatums next) {
		//查找这个页面所有的a标签下的href属性放到这个Elements标签集合中
		Elements elements = page.select("a[href]");
		//遍历elements获取我们需要的href属性的值
		for (Element e : elements) {
			//获取url
			String url = e.absUrl("href");
			//判断这个url是不是我们所要的url
			if(url.matches(urlRegex)){
				try {
					//用Jsoup的方法获取网页的信息
					Document doc = Jsoup.connect(url).followRedirects(true).method(Method.GET).execute().parse();
					
					Elements els = doc.select("a[href]");
					for (Element element : els) {
						String toUrl = element.absUrl("href");
						element.text();
						if (toUrl.matches(songRegex)) {
							System.out.println("开始下载歌曲："+element.text());
						}
						
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		HotSong hotSong = new HotSong("crawl", true);
		hotSong.setThreads(2);
		hotSong.setTopN(5000);
		hotSong.start(4);
	}
}
