package com.maven.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maven.service.CTOService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/51cto")
public class CtoController {

	@Autowired
	private CTOService ctoService;

	@RequestMapping(value = "/selectCourseByVideoID", produces = "text/html;charset=UTF-8;")
	@ResponseBody
	public String selectCourseByVideoID(Integer video_url_id) {

		List<Map<String, String>> CourseList = ctoService.selectCourseByVideoID(4186);
		JSONArray json = JSONArray.fromObject(CourseList);
		
		return json.toString();

	}

	@RequestMapping(value = "/selectVideoUrlList", produces = "text/html;charset=UTF-8;")
	@ResponseBody
	public String selectVideoUrlList() {

		List<Map<String, String>> VideoList = ctoService.selectVideoUrlList();
		JSONArray json = JSONArray.fromObject(VideoList);

		return json.toString();

	}
}
