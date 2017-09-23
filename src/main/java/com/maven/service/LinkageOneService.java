package com.maven.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven.dao.ILinkageOneDao;
import com.maven.entity.Linkage_One;

@Service
public class LinkageOneService {

	@Autowired
	private ILinkageOneDao lod;
	
	public List<Linkage_One> selectLinkage_one(int page){
		
		return lod.selectLinkage_one(page);
		
	}
	
	public int insertLinkage_one(Linkage_One lo){
		
		return lod.insertLinkage_one(lo);
		
	}
	
	public Integer selectDataTotal(){
		
		return lod.selectDataTotal();
	}
	
	public List<Linkage_One> getCurrentData(Map<String,Integer> map){
		
		return lod.getCurrentData(map);
	}
}
