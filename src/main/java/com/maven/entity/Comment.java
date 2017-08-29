package com.maven.entity;

/**
 * 用户评论表
 * @author liyongqiang
 *
 */
public class Comment {

	private String id;
	private String comment_user_id;
	private String news_id;
	private String comment_conten;
	private String comment_time;
	private Integer support_count;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getComment_user_id() {
		return comment_user_id;
	}
	public void setComment_user_id(String comment_user_id) {
		this.comment_user_id = comment_user_id;
	}
	public String getNews_id() {
		return news_id;
	}
	public void setNews_id(String news_id) {
		this.news_id = news_id;
	}
	public String getComment_conten() {
		return comment_conten;
	}
	public void setComment_conten(String comment_conten) {
		this.comment_conten = comment_conten;
	}
	public String getComment_time() {
		return comment_time;
	}
	public void setComment_time(String comment_time) {
		this.comment_time = comment_time;
	}
	public Integer getSupport_count() {
		return support_count;
	}
	public void setSupport_count(Integer support_count) {
		this.support_count = support_count;
	}
	
	

	
}
