package com.maven.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.maven.entity.Dictionary;
import com.maven.service.DictionaryService;
import com.maven.util.DateUtil;

import net.sf.json.JSONArray;

/**
 * 数据字典控制层
 * 
 * @author Li Yongqiang
 *
 */
@Controller
@RequestMapping("/dictionary")
public class DictionaryController {

	@Autowired
	private DictionaryService dictService;
	private DateUtil dateUtil;
	JSONObject json = new JSONObject();

	/**
	 * 获取全部数据字典
	 * 
	 * @return
	 */
	@RequestMapping(value = "/selectAllDictionary", produces = "text/html;charset=UTF-8;")
	@ResponseBody
	public String selectAllDictionary() {

		List<Map<String, String>> map = dictService.selectAllDictionary();
		JSONArray jsonArray = JSONArray.fromObject(map);
		return jsonArray.toString();
	}

	/**
	 * 根据ID查询数据字典
	 * 
	 * @param ID
	 * @return
	 */
	@RequestMapping(value = "/selectDictionaryByID", produces = "text/html;charset=UTF-8;")
	@ResponseBody
	public String selectDictionaryByID(String ID) {
		Map<String, String> map = dictService.selectDictionaryByID(ID);
		String json = JSON.toJSONString(map);
		return json;

	}

	/**
	 * 添加数据字典
	 * 
	 * @param dictionary_key
	 * @param dictionary_value
	 * @return
	 */
	@RequestMapping(value = "/insertDictionary", produces = "text/html;charset=UTF-8;")
	@ResponseBody
	public String insertDictionary(String dictionary_key, String dictionary_value) {

		String ID = UUID.randomUUID().toString();
		Dictionary dict = new Dictionary();
		dict.setDictionary_id(ID);
		dict.setDictionary_key(dictionary_key);
		dict.setDictionary_value(dictionary_value);
		dict.setDictionary_create_time(dateUtil.getYMDHMS());
		dict.setDictionary_creater("李永强");
		Integer state = dictService.insertDictionary(dict);
		json.put("state", state);
		return json.toString();

	}

	/**
	 * 删除数据字典
	 * 
	 * @param dictionary_id
	 * @return
	 */
	@RequestMapping(value = "/deleteDictionary", produces = "text/html;charset=UTF-8;")
	@ResponseBody
	public String deleteDictionary(String dictionary_id) {

		Integer state = dictService.deleteDictionary(dictionary_id);
		json.put("state", state);
		return json.toString();

	}

	/**
	 * 更新数据字典
	 * 
	 * @param dictionary_key
	 * @param dictionary_value
	 * @return
	 */
	@RequestMapping(value = "/updateDictionary", produces = "text/html;charset=UTF-8;")
	@ResponseBody
	public String updateDictionary(String dictionary_key, String dictionary_value) {

		Map<String, String> map = new HashMap<String, String>();

		map.put("dictionary_key", dictionary_key);
		map.put("dictionary_value", dictionary_value);
		map.put("dictionary_modifier", "李永强");
		map.put("dictionary_update_time", dateUtil.getYMDHMS());

		Integer state = dictService.updateDictionary(map);

		json.put("state", state);

		return json.toString();

	}

	/**
	 * 获取总页数与数据总条数
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getDataTotal", produces = "text/html;charset=UTF-8;")
	@ResponseBody
	public String getDataTotal(String dictionary_key, String dictionary_value, String dictionary_create_time) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("dictionary_key", dictionary_key);
		map.put("dictionary_value", dictionary_value);
		map.put("dictionary_create_time", dictionary_create_time);
		// 每页数据条数
		@SuppressWarnings("unused")
		int pageData = 10;
		// 数据总数
		Integer dataTotal = dictService.getDataTotal(map);
		// 总页数
		Integer pageTotal = dataTotal / 10;
		if (dataTotal % 10 > 0) {
			pageTotal++;
		}
		json.put("dataTotal", dataTotal);
		json.put("pageTotal", pageTotal);
		return json.toString();

	}

	/**
	 * 分页模糊查询每页的数据
	 * 
	 * @param dictionary_key
	 * @param dictionary_value
	 * @param dictionary_create_time
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/getDataByConditions", produces = "text/html;charset=UTF-8;")
	@ResponseBody
	public String getDataByConditions(String dictionary_key, String dictionary_value, String dictionary_create_time,
			Integer page) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(page == null){
			page = 0;
		}
		map.put("dictionary_key", dictionary_key);
		map.put("dictionary_value", dictionary_value);
		map.put("dictionary_create_time", dictionary_create_time);
		map.put("start", page*10);
		map.put("dataSize", 10);
		List<Map<String, Object>> dataByConditions = dictService.getDataByConditions(map);
		JSONArray jsonArray = JSONArray.fromObject(dataByConditions);
		return jsonArray.toString();

	}
}
