package com.xck.blog.model;

import java.util.Date;

public class Article {
	int article_id;
	String article_title;
	Date article_time;
	int article_click;
	int article_comment;
	int article_up;
	int article_type;
	int article_isComment;
	String article_content;
	int int_grouping;
	String article_grouping;  //在数据库中是关联的外键
	
	public Article(int article_id, String article_title, Date article_time, int article_click, 
			int article_comment, int article_up, int article_type, int article_isComment, String article_grouping){
		this.article_id = article_id;
		this.article_title = article_title;
		this.article_time = article_time;
		this.article_click = article_click;
		this.article_comment = article_comment;
		this.article_up = article_up;
		this.article_type = article_type;
		this.article_isComment = article_isComment;
		this.article_grouping = article_grouping;
	}
	
	public Article(String article_title, Date article_time, int article_click, 
			int article_comment, int article_up, int article_type, int article_isComment, String article_content,
			String article_grouping){
		this.article_title = article_title;
		this.article_time = article_time;
		this.article_click = article_click;
		this.article_comment = article_comment;
		this.article_up = article_up;
		this.article_type = article_type;
		this.article_isComment = article_isComment;
		this.article_content = article_content;
		this.article_grouping = article_grouping;
	}
	
	public int getArticle_id() {
		return article_id;
	}
	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}
	public String getArticle_title() {
		return article_title;
	}
	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}
	public Date getArticle_time() {
		return article_time;
	}
	public void setArticle_time(Date article_time) {
		this.article_time = article_time;
	}
	public int getArticle_click() {
		return article_click;
	}
	public void setArticle_click(int article_click) {
		this.article_click = article_click;
	}
	public int getArticle_comment() {
		return article_comment;
	}
	public void setArticle_comment(int article_comment) {
		this.article_comment = article_comment;
	}
	public int getArticle_up() {
		return article_up;
	}
	public void setArticle_up(int article_up) {
		this.article_up = article_up;
	}
	public int getArticle_type() {
		return article_type;
	}
	public void setArticle_type(int article_type) {
		this.article_type = article_type;
	}
	public int getArticle_isComment() {
		return article_isComment;
	}
	public void setArticle_isComment(int article_isComment) {
		this.article_isComment = article_isComment;
	}

	public String getArticle_content() {
		return article_content;
	}

	public void setArticle_content(String article_content) {
		this.article_content = article_content;
	}

	public String getArticle_grouping() {
		return article_grouping;
	}

	public void setArticle_grouping(String article_grouping) {
		this.article_grouping = article_grouping;
	}

	public int getInt_grouping() {
		return int_grouping;
	}

	public void setInt_grouping(int int_grouping) {
		this.int_grouping = int_grouping;
	}
}
