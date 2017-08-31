package com.maven.dao;

import java.util.List;

import com.maven.entity.Website_One;

public interface IWebsiteOneDao {

	public int insertWebsiteOne(Website_One wo);
	
	public int deleteWebsiteOne(Integer id);
	
	public int updateWebsiteOne(Website_One wo);
	
	public List<Website_One> selectWebsiteOne(Website_One wo);
}
