package com.xck.blog.model;

public class ArticleGrouping {
	private int id;
	private String name;
	private int amount;
	private String image;
	private int sort_id;
	
	public ArticleGrouping(int id, String name, int amount, String image, int sort_id){
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.image = image;
		this.sort_id = sort_id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getSort_id() {
		return sort_id;
	}
	public void setSort_id(int sort_id) {
		this.sort_id = sort_id;
	}
	
	
}
