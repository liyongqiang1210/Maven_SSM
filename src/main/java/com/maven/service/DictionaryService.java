package com.maven.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven.dao.IDictionaryDao;
import com.maven.entity.Dictionary;

@Service
public class DictionaryService {

	@Autowired
	private IDictionaryDao dictionaryDao;

	public List<Map<String, String>> selectAllDictionary() {

		return dictionaryDao.selectAllDictionary();

	}

	public Map<String, String> selectDictionaryByID(String ID) {

		return dictionaryDao.selectDictionaryByID(ID);
	}

	public Integer insertDictionary(Dictionary dict) {

		return dictionaryDao.insertDictionary(dict);
	}

	public Integer deleteDictionary(String ID) {

		return dictionaryDao.deleteDictionary(ID);
	}

	public Integer updateDictionary(Map<String, String> map) {

		return dictionaryDao.updateDictionary(map);
	}

	public Integer getDataTotal(Map<String, String> map) {

		return dictionaryDao.getDataTotal(map);

	}

	public List<Map<String, Object>> getDataByConditions(Map<String, Object> map) {

		return dictionaryDao.getDataByConditions(map);

	}

}
