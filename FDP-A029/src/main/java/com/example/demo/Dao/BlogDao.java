package com.example.demo.Dao;

import java.util.List;

import com.example.demo.Model.Blog;

public interface BlogDao {
	/*
	 * This is the interface class for all the functions implemented
	 * in blogsDaoIMPL class.
	 */

	public Blog getBlog(int blogId);
	public Blog insertBlog(Blog blog);
	public Blog updateBlog(Blog blog);
	public Boolean deleteBlog(int Blog_ID);
	public List<Blog> viewAllBlogs();
}
