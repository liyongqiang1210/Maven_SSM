package com.maven.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven.dao.INewsDao;
import com.maven.entity.News;

@Service
public class NewsService {

	@Autowired
	private INewsDao newsdao;
	public int insertNews(News news){
		
		return newsdao.insertNews(news);
		
	}
}
