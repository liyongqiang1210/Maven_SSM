package com.maven.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven.dao.IWebsiteThreeDao;
import com.maven.entity.Website_Three;

@Service
public class WebsiteThreeService {

	@Autowired
	private IWebsiteThreeDao WebsiteThreeDao;
	
	public Integer insertWebsite(Website_Three wt){
		
		return WebsiteThreeDao.insertWebsiteThree(wt);
	}
	
	public Integer deleteWebsite(Integer id){
		
		return WebsiteThreeDao.deleteWebsiteThree(id);
		
	}
	
	public Integer UpdateWebsite(Website_Three wt){
		
		return WebsiteThreeDao.updateWebsiteThree(wt);
		
	}
	
	public List<Website_Three> selectWebsite(Website_Three wt){
		
		return WebsiteThreeDao.selectWebsiteThree(wt);
		
	}
}
