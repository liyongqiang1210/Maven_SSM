package com.maven.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maven.entity.News;
import com.maven.service.NewsService;

@Controller
public class NewsController {

	@Autowired
	private NewsService newsService;
	
	/**
	 * 获取新闻数据
	 * @param model
	 * @return
	 */
	@RequestMapping("getAllNews")
	public String getAllNews(Model model){
		List<News> list = newsService.getAllNews();
		model.addAttribute("News", list);
		return "jsp/right";
	}
}
