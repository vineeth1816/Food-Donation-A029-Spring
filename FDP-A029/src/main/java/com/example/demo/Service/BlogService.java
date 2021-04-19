package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DaoImpl.BlogDaoImpl;
import com.example.demo.Model.Blog;

@Service
public class BlogService {

	@Autowired
	BlogDaoImpl blogDaoImpl;
	
	public Blog addBlog(Blog blog) {
		
		return blogDaoImpl.insertBlog(blog);
		
	}
	
	public Blog updateBlog(Blog blog) {
		
		return blogDaoImpl.updateBlog(blog);
	}
	
	public Boolean deleteBlog(int Blog_ID) {
		return blogDaoImpl.deleteBlog(Blog_ID);
	}
	
	public List<Blog> viewAllBlogs(){
		return blogDaoImpl.viewAllBlogs();
	}
	public Blog getBlog(int Blog_ID) {
		return blogDaoImpl.getBlog(Blog_ID);
	}
}
