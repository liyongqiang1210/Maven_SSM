package com.maven.dao;

import java.util.List;
import java.util.Map;

public interface I51CTODao {

	public List<Map<String,String>> selectCourseByVideoID(Integer video_url_id); // 根据视频的id查询对应的课程列表
	
	public List<Map<String,String>> selectVideoUrlList();//查询所有视频列表
}
