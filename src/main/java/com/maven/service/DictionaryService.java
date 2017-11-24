package com.maven.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	public Integer deleteDictionaryByID(String ID) {

		return dictionaryDao.deleteDictionaryByID(ID);
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

	@Transactional
	public Integer deleteDictionarysByID(List<String> list) {
		int h = 0;
		int state = 0;
		try {
			for(int i = 0;i<list.size();i++){
				h = deleteDictionaryByID(list.get(i));
				/*if(h == 1){
					state = 1;
				}else{
					state=0;
					throw new RuntimeException();
				}*/
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

}
