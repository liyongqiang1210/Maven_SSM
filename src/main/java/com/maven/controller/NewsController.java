package com.maven.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.maven.entity.News;
import com.maven.service.NewsService;

@Controller
public class NewsController {

	@Autowired
	private NewsService newsService;

	/**
	 * 获取新闻数据首页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("getAllNews")
	public String getAllNews(Model model, Integer start) {

		if (start == null) {
			start = 0;
		} else {
			start = start * 10;
		}
		// 获取新闻列表
		List<News> list = newsService.getNewsToPage(start);
		for(News news:list){
			if(news.getTitle().length()>30){
				news.setTitle(news.getTitle().substring(0, 20)+"....");
			}
			news.setCreate_time(news.getCreate_time().substring(0, 19));
			news.setRelease_time(news.getRelease_time().substring(0, 19));
			
		}
		model.addAttribute("News", list);

		// 获取数据数量
		int dataTotal = newsService.getAllNews();
		model.addAttribute("dataTotal", dataTotal);
		// 获取数据总页数
		int pageTotal = 1;
		if (dataTotal % 13 > 0) {
			pageTotal = dataTotal / 13 + 1;
		} else {
			pageTotal = dataTotal / 13;
		}

		model.addAttribute("pageTotal", pageTotal);
		return "jsp/right";
	}

	/**
	 * 分页查询新闻数据
	 * @param model
	 * @param start
	 */
	@RequestMapping(value="getNewsToPage",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String getNewToPage(Integer start) {
		if (start == null||start == 1) {
			start = 0;
		} else {
			start = (start-1) * 10;
		}
		List<News> list= newsService.getNewsToPage(start);
		for(News news:list){
			news.setCreate_time(news.getCreate_time().substring(0, 19));
			news.setRelease_time(news.getRelease_time().substring(0, 19));
		}
		JSONArray json = new JSONArray();
		for (News news : list) {
			json.add(news);
		}
		String js = json.toString();
		return js;
		
	}
}
