package com.maven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 联动控制层
 * @author liyongqiang
 *
 */
@Controller
@RequestMapping("/linkage")
public class LinkageController {

	
	@RequestMapping("/getLinkage")
	public String addLinkage(){
		
		return "jsp/linkage";
		
	}
}
