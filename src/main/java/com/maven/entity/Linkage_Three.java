package com.maven.entity;

import java.io.Serializable;

public class Linkage_Three implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String lth_id;
	private String lth_name;
	private String ltw_id;
	private String lth_create_time;
	private String lth_creater;
	private String lth_update_time;
	private String lth_modifier;

	public String getLth_id() {
		return lth_id;
	}

	public void setLth_id(String lth_id) {
		this.lth_id = lth_id;
	}

	public String getLth_name() {
		return lth_name;
	}

	public void setLth_name(String lth_name) {
		this.lth_name = lth_name;
	}

	public String getLtw_id() {
		return ltw_id;
	}

	public void setLtw_id(String ltw_id) {
		this.ltw_id = ltw_id;
	}

	public String getLth_create_time() {
		return lth_create_time;
	}

	public void setLth_create_time(String lth_create_time) {
		this.lth_create_time = lth_create_time;
	}

	public String getLth_creater() {
		return lth_creater;
	}

	public void setLth_creater(String lth_creater) {
		this.lth_creater = lth_creater;
	}

	public String getLth_update_time() {
		return lth_update_time;
	}

	public void setLth_update_time(String lth_update_time) {
		this.lth_update_time = lth_update_time;
	}

	public String getLth_modifier() {
		return lth_modifier;
	}

	public void setLth_modifier(String lth_modifier) {
		this.lth_modifier = lth_modifier;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
