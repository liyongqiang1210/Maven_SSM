package com.maven.entity;

import java.io.Serializable;

public class Linkage_Two implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ltw_id;
	private String ltw_name;
	private String lo_id;
	private String ltw_create_time;
	private String ltw_creater;
	private String ltw_update_time;
	private String ltw_modifier;

	public String getLtw_id() {
		return ltw_id;
	}

	public void setLtw_id(String ltw_id) {
		this.ltw_id = ltw_id;
	}

	public String getLtw_name() {
		return ltw_name;
	}

	public void setLtw_name(String ltw_name) {
		this.ltw_name = ltw_name;
	}

	public String getlo_id() {
		return lo_id;
	}

	public void setlo_id(String lo_id) {
		this.lo_id = lo_id;
	}

	public String getltw_create_time() {
		return ltw_create_time;
	}

	public void setltw_create_time(String ltw_create_time) {
		this.ltw_create_time = ltw_create_time;
	}

	public String getltw_creater() {
		return ltw_creater;
	}

	public void setltw_creater(String ltw_creater) {
		this.ltw_creater = ltw_creater;
	}

	public String getltw_update_time() {
		return ltw_update_time;
	}

	public void setltw_update_time(String ltw_update_time) {
		this.ltw_update_time = ltw_update_time;
	}

	public String getltw_modifier() {
		return ltw_modifier;
	}

	public void setltw_modifier(String ltw_modifier) {
		this.ltw_modifier = ltw_modifier;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
