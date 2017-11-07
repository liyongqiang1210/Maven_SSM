package com.maven.entity;

import java.io.Serializable;

public class Dictionary implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dictionary_id;
	private String dictionary_key;
	private String dictionary_value;
	private String dictionary_create_time;
	private String dictionary_update_time;
	private String dictionary_modifier;
	private String dictionary_creater;

	public String getDictionary_id() {
		return dictionary_id;
	}
	public void setDictionary_id(String dictionary_id) {
		this.dictionary_id = dictionary_id;
	}
	public String getDictionary_key() {
		return dictionary_key;
	}
	public void setDictionary_key(String dictionary_key) {
		this.dictionary_key = dictionary_key;
	}
	public String getDictionary_value() {
		return dictionary_value;
	}
	public void setDictionary_value(String dictionary_value) {
		this.dictionary_value = dictionary_value;
	}
	public String getDictionary_create_time() {
		return dictionary_create_time;
	}
	public void setDictionary_create_time(String dictionary_create_time) {
		this.dictionary_create_time = dictionary_create_time;
	}
	public String getDictionary_update_time() {
		return dictionary_update_time;
	}
	public void setDictionary_update_time(String dictionary_update_time) {
		this.dictionary_update_time = dictionary_update_time;
	}
	public String getDictionary_modifier() {
		return dictionary_modifier;
	}
	public void setDictionary_modifier(String dictionary_modifier) {
		this.dictionary_modifier = dictionary_modifier;
	}
	public String getDictionary_creater() {
		return dictionary_creater;
	}
	public void setDictionary_creater(String dictionary_creater) {
		this.dictionary_creater = dictionary_creater;
	}
	
	
}
