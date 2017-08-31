package com.maven.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven.dao.IWebsiteOneDao;
import com.maven.entity.Website_One;

@Service
public class WebsiteOneService {

	@Autowired
	private IWebsiteOneDao WebsiteoneDao;
	
	public Integer insertWebsite(Website_One wo){
		
		return WebsiteoneDao.insertWebsiteOne(wo);
	}
	
	public Integer deleteWebsite(Integer id){
		
		return WebsiteoneDao.deleteWebsiteOne(id);
		
	}
	
	public Integer UpdateWebsite(Website_One wo){
		
		return WebsiteoneDao.updateWebsiteOne(wo);
		
	}
	
	public List<Website_One> selectWebsite(Website_One wo){
		
		return WebsiteoneDao.selectWebsiteOne(wo);
		
	}
}
