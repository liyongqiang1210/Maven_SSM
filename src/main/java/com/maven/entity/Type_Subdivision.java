package com.maven.entity;

/**
 * 新闻类别分支实体类
 * 
 * @author liyongqiang
 *
 */
public class Type_Subdivision {
	
	private String id;
	private String Subdivision_name;
	private String news_id;
	private String create_time;
	private String update_time;
	private String creater;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSubdivision_name() {
		return Subdivision_name;
	}

	public void setSubdivision_name(String subdivision_name) {
		Subdivision_name = subdivision_name;
	}

	public String getNews_id() {
		return news_id;
	}

	public void setNews_id(String news_id) {
		this.news_id = news_id;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

}
