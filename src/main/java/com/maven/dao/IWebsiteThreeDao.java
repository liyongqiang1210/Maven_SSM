package com.maven.dao;

import java.util.List;

import com.maven.entity.Website_Three;

public interface IWebsiteThreeDao {

	public int insertWebsiteThree(Website_Three wt);
	
	public int deleteWebsiteThree(Integer id);
	
	public int updateWebsiteThree(Website_Three wt);
	
	public List<Website_Three> selectWebsiteThree(Website_Three wt);
}
