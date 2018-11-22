package com.spring.entity;


public class HerosEntity {
	private int id;
	private String name;
	private String imgUrl;
	private String history;
	private String categoryId;
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getImgUrl(){
		return this.imgUrl;
	}
	
	public void setImgUrl(String imgUrl){
		this.imgUrl = imgUrl;
	}
	
	public String getHistory(){
		return this.history;
	}
	
	public void setHistory(String history){
		this.history = history;
	}
	
	public String getCategoryId(){
		return this.categoryId;
	}
	
	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}
	
	
}
