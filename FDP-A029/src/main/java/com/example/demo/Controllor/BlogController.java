package com.example.demo.Controllor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Blog;
import com.example.demo.Service.BlogService;

@RestController
public class BlogController {

	@Autowired
	BlogService blogService;
	
	/*
	 * Method taking the inputs from sever and passing 
	 * the details into the addblog service method to add 
	 *  details into blog in database. 
	 */

	@PostMapping("addBlog")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<Object> addBlog(@RequestBody Blog blog) {

		try {

			return new ResponseEntity<Object>(blogService.addBlog(blog), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*
	 * Method taking the inputs from sever and passing 
	 * the details into the update blog service method to update
	 *  details into blog in database. 
	 */
	

	@PutMapping("updateBlog")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<Object> updateBlog(@RequestBody Blog blog) {
		try {

			return new ResponseEntity<Object>(blogService.updateBlog(blog), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*
	 * Method taking the inputs from sever and passing 
	 * the details into the deleteblog service method to delete
	 *  details in blog in database. 
	 */


	@DeleteMapping("deleteBlog/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<Object> deleteBlog(@PathVariable int id) {

		try {

			return new ResponseEntity<Object>(blogService.deleteBlog(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*
	 * Method taking the inputs from sever and passing 
	 * the details into the veiwallblog service method to retrieve
	 *  details from  blog in database. 
	 */

	@GetMapping("viewAllBlogs")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<List<Blog>> viewAllBlogs() {
		
		List<Blog> s=blogService.viewAllBlogs();
		
			return new ResponseEntity<List<Blog>>(s, HttpStatus.OK);
		
	}
	
	/*
	 * Method taking the inputs from sever and passing 
	 * the details into the getblog service method to retrieve 
	 *  details of specified blog  from  database. 
	 */
	
	@GetMapping("/getBlog/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<Blog> getBlog(@PathVariable int id) {
		
		Blog blog=blogService.getBlog(id);
		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
		
	}
	
}
