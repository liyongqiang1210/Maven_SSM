package com.maven.dao;

import java.util.List;

import com.maven.entity.Website_Two;

public interface IWebsiteTwoDao {

	public int insertWebsiteTwo(Website_Two wt);
	
	public int deleteWebsiteTwo(Integer id);
	
	public int updateWebsiteTwo(Website_Two wt);
	
	public List<Website_Two> selectWebsiteTwo(Website_Two wt);
}
