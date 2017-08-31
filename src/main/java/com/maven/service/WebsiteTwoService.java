package com.maven.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven.dao.IWebsiteTwoDao;
import com.maven.entity.Website_Two;

@Service
public class WebsiteTwoService {

	@Autowired
	private IWebsiteTwoDao WebsiteTwoDao;
	
	public Integer insertWebsite(Website_Two wt){
		
		return WebsiteTwoDao.insertWebsiteTwo(wt);
	}
	
	public Integer deleteWebsite(Integer id){
		
		return WebsiteTwoDao.deleteWebsiteTwo(id);
		
	}
	
	public Integer UpdateWebsite(Website_Two wt){
		
		return WebsiteTwoDao.updateWebsiteTwo(wt);
		
	}
	
	public List<Website_Two> selectWebsite(Website_Two wt){
		
		return WebsiteTwoDao.selectWebsiteTwo(wt);
		
	}
}
