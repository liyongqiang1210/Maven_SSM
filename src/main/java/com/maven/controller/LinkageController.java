package com.maven.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maven.entity.Linkage_One;
import com.maven.service.LinkageOneService;

/**
 * 联动控制层
 * 
 * @author liyongqiang
 *
 */
@Controller
@RequestMapping("/linkage")
public class LinkageController {

	@Autowired
	private LinkageOneService los;

	// 每页记录数
	int Page_Data = 5;

	/**
	 * 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/getLinkageOne")
	public String getLinkageOne() {
		
		return "jsp/linkage";

	}

	/**
	 * 获取当前页的数据
	 * 
	 * @param start
	 *            从第几条开始查
	 * @param total
	 *            查询多少条数据
	 * @param model
	 */
	@RequestMapping(value="/getLinkageOneData",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String getLinkageOneData(Integer start, Integer total) {
		List<Linkage_One> list = null;
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("total", total);
		if (start != null && total !=null) {
			list = los.getCurrentData(map);
		}
		JSONArray ja = new JSONArray();
		ja.put(list);
		return ja.toString();
	}

	/**
	 * 查询总页数和数据总数
	 * 
	 * @return
	 */
	@RequestMapping(value="/getPageTotal",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String getPageTotal() {
		Integer dataTotal = 0;
		Integer pageTotal = 0;
		// 数据总数
		if (los.selectDataTotal() != null) {
			dataTotal = los.selectDataTotal();
		}
		// 每页显示15条记录
		if (dataTotal % Page_Data > 0) {
			pageTotal = dataTotal / Page_Data + 1;
		} else {
			pageTotal = dataTotal / Page_Data;
		}

		JSONObject json = new JSONObject();
		json.put("dataTotal", dataTotal);
		json.put("pageTotal", pageTotal);
		return json.toString();
	}
}
