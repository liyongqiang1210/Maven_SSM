package com.maven.dao;

import java.util.List;

import com.maven.entity.News;

public interface INewsDao {

	public Integer insertNews(News news);
	
	public Integer getAllNews();
	
	public List<News> getNewsToPage(Integer start);
}
