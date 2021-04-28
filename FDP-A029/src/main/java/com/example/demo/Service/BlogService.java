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
	
	/*
	 * This method is used to call the 
	 * insertBlog implementation in 
	 * DaoImplementation class.
	 */
	
	public Blog addBlog(Blog blog) {
		
		return blogDaoImpl.insertBlog(blog);
		
	}
	
	/*
	 *  This method is used to call the 
	 * updateBlog implementation in 
	 * DaoImplementation class.
	 */
	
	public Blog updateBlog(Blog blog) {
		
		return blogDaoImpl.updateBlog(blog);
	}
	
	/*
	 *  This method is used to call the 
	 * deleteBlog implementation in 
	 * DaoImplementation class.
	 */
	
	public Boolean deleteBlog(int Blog_ID) {
		return blogDaoImpl.deleteBlog(Blog_ID);
	}
	
	/*
	 *  This method is used to call the 
	 * viewallBlogs implementation in 
	 * DaoImplementation class.
	 */
	
	public List<Blog> viewAllBlogs(){
		return blogDaoImpl.viewAllBlogs();
	}
	
	/*
	 *  This method is used to call the 
	 * getBlog implementation in 
	 * DaoImplementation class.
	 */
	
	public Blog getBlog(int Blog_ID) {
		return blogDaoImpl.getBlog(Blog_ID);
	}
}
