package com.example.demo.Model;

public class Blog {

	
	@Override
	public String toString() {
		return "Blog [blog_ID=" + blog_ID + ", blog_Title=" + blog_Title + ", description=" + description + "]";
	}
	public int getBlog_ID() {
		return blog_ID;
	}
	public void setBlog_ID(int blog_ID) {
		this.blog_ID = blog_ID;
	}
	public String getBlog_Title() {
		return blog_Title;
	}
	public void setBlog_Title(String blog_Title) {
		this.blog_Title = blog_Title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private int blog_ID;
	private String blog_Title;
	private String description;
	
	
}
