package com.maven.entity;

/**
 * 二级 网址实体类
 * 
 * @author Li Yongqiang
 *
 */
public class Website_Two {

	private String id;
	private String url;
	private String name;
	private String website_one_id;
	private String create_time;
	private String update_time;
	private String creater;
	private String modifier;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebsite_one_id() {
		return website_one_id;
	}

	public void setWebsite_one_id(String website_one_id) {
		this.website_one_id = website_one_id;
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

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

}
