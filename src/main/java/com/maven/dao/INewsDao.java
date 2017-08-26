package com.maven.dao;

import java.util.List;

import com.maven.entity.News;

public interface INewsDao {

	public int insertNews(News news);
	
	public List<News> getAllNews();
}
