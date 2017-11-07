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
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.maven.entity.Dictionary;
import com.maven.service.DictionaryService;
import com.maven.util.DateUtil;

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
		String jsonArray = JSONArray.toJSONString(map);
		return jsonArray;
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
	@RequestMapping(value = "insertDictionary", produces = "text/html;charset=UTF-8;")
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
	@RequestMapping(value = "deleteDictionary", produces = "text/html;charset=UTF-8;")
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
	@RequestMapping(value = "updateDictionary", produces = "text/html;charset=UTF-8;")
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
}
