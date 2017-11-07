package com.maven.dao;

import java.util.List;
import java.util.Map;

import com.maven.entity.Dictionary;

/**
 * 数据字典接口
 * 
 * @author Li Yongqiang
 *
 */
public interface IDictionaryDao {

	// 查询全部数据字典
	public List<Map<String, String>> selectAllDictionary();

	// 根据ID查询对应的数据字典
	public Map<String, String> selectDictionaryByID(String ID);

	// 添加数据字典
	public Integer insertDictionary(Dictionary dict);

	// 根据ID删除数据字典
	public Integer deleteDictionary(String ID);

	// 修改数据字典
	public Integer updateDictionary(Map<String, String> map);
}
