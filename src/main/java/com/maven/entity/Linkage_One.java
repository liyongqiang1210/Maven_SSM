package com.maven.entity;

import java.io.Serializable;

public class Linkage_One implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String lo_id;
	private String lo_name;
	private String lo_create_time;
	private String lo_creater;
	private String lo_update_time;
	private String lo_modifier;

	public String getLo_id() {
		return lo_id;
	}

	public void setLo_id(String lo_id) {
		this.lo_id = lo_id;
	}

	public String getLo_name() {
		return lo_name;
	}

	public void setLo_name(String lo_name) {
		this.lo_name = lo_name;
	}

	public String getLo_create_time() {
		return lo_create_time;
	}

	public void setLo_create_time(String lo_create_time) {
		this.lo_create_time = lo_create_time;
	}

	public String getLo_creater() {
		return lo_creater;
	}

	public void setLo_creater(String lo_creater) {
		this.lo_creater = lo_creater;
	}

	public String getLo_update_time() {
		return lo_update_time;
	}

	public void setLo_update_time(String lo_update_time) {
		this.lo_update_time = lo_update_time;
	}

	public String getLo_modifier() {
		return lo_modifier;
	}

	public void setLo_modifier(String lo_modifier) {
		this.lo_modifier = lo_modifier;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
