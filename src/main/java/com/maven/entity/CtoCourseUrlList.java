package com.maven.entity;

/**
 * 51cto课程详细视频表
 * @author liyongqiang
 *
 */
public class CtoCourseUrlList {

	private Integer course_id;
	private String course_url;
	private String course_title;
	private Integer video_url_id;
	private Integer course_is_craw;

	public Integer getCourse_id() {
		return course_id;
	}

	public void setCourse_id(Integer course_id) {
		this.course_id = course_id;
	}

	public String getCourse_url() {
		return course_url;
	}

	public void setCourse_url(String course_url) {
		this.course_url = course_url;
	}

	public String getCourse_title() {
		return course_title;
	}

	public void setCourse_title(String course_title) {
		this.course_title = course_title;
	}

	public Integer getVideo_url_id() {
		return video_url_id;
	}

	public void setVideo_url_id(Integer video_url_id) {
		this.video_url_id = video_url_id;
	}

	public Integer getCourse_is_craw() {
		return course_is_craw;
	}

	public void setCourse_is_craw(Integer course_is_craw) {
		this.course_is_craw = course_is_craw;
	}

}
