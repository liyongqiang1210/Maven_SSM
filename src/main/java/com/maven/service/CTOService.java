package com.maven.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven.dao.I51CTODao;

@Service
public class CTOService {

	@Autowired
	private I51CTODao CtoCourseUrlListDao;

	public List<Map<String, String>> selectCourseByVideoID(Integer video_url_id) {
		return CtoCourseUrlListDao.selectCourseByVideoID(video_url_id);
	}

	public List<Map<String, String>> selectVideoUrlList() {

		return CtoCourseUrlListDao.selectVideoUrlList();

	}

}
