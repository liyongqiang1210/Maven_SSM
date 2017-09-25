package com.maven.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
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
	// 每页记录数默认15页
	private Integer total = 15;

	/**
	 * 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/getLinkageOne")
	public String getLinkageOne(Model model) {
		// 获取首页数据
		List<Linkage_One> list = null;
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", 0);
		map.put("total", total);
		list = los.getCurrentData(map);
		model.addAttribute("linkages", list);
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
	@RequestMapping(value = "/getLinkageOneData", produces = "text/html;charset=UTF-8;")
	@ResponseBody
	public String getLinkageOneData(Integer start, Integer total) {
		List<Linkage_One> list = null;
		Map<String, Integer> map = new HashMap<String, Integer>();

		if (total == null) {
			total = 5;
		}
		// sql语句中查询数据时的开始查询的位置
		if (start == 1) {
			map.put("start", 0);
		} else {
			map.put("start", (start - 1) * total);
		}

		map.put("total", total);
		if (start != null && total != null) {
			// 获取当前页数据
			list = los.getCurrentData(map);
		}
		JSONArray ja = new JSONArray();
		for (Linkage_One linkage_One : list) {

			// 过滤掉查询出来的控制，避免jsp页面的报undefined错误
			if (linkage_One.getLo_create_time() == null) {
				linkage_One.setLo_create_time("");
			}
			if (linkage_One.getLo_creater() == null) {
				linkage_One.setLo_creater("");
			}
			if (linkage_One.getLo_update_time() == null) {
				linkage_One.setLo_update_time("");
			}
			if (linkage_One.getLo_modifier() == null) {
				linkage_One.setLo_modifier("");
			}
			ja.add(linkage_One);
		}
		// 将json数组换为String字符串
		String json = ja.toString();
		return json;
	}

	/**
	 * 查询总页数和数据总数
	 * 
	 * @param total
	 *            每页记录数
	 * @return
	 */
	@RequestMapping(value = "/getPageTotal", produces = "text/html;charset=UTF-8;")
	@ResponseBody
	public String getPageTotal(Integer total) {
		Integer dataTotal = 0;
		Integer pageTotal = 0;
		// 数据总数
		if (los.selectDataTotal() != null) {
			dataTotal = los.selectDataTotal();
		}
		// 每页显示15条记录
		if (dataTotal % total > 0) {
			pageTotal = dataTotal / total + 1;
		} else {
			pageTotal = dataTotal / total;
		}

		JSONObject json = new JSONObject();
		json.put("dataTotal", dataTotal);
		json.put("pageTotal", pageTotal);
		return json.toString();
	}
}
