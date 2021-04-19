package com.example.demo.Controllor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Blog;
import com.example.demo.Service.BlogService;

@RestController
public class BlogController {

	@Autowired
	BlogService blogService;

	@PostMapping("addBlog")
	public ResponseEntity<Object> addBlog(@RequestBody Blog blog) {

		try {

			return new ResponseEntity<Object>(blogService.addBlog(blog), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("updateBlog")
	public ResponseEntity<Object> updateBlog(@RequestBody Blog blog) {
		try {

			return new ResponseEntity<Object>(blogService.updateBlog(blog), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("deleteBlog")
	public ResponseEntity<Object> deleteBlog(@RequestBody Blog blog) {
		try {

			return new ResponseEntity<Object>(blogService.deleteBlog(blog.getBlog_ID()), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("viewAllBlogs")
	public ResponseEntity<List<Blog>> viewAllBlogs() {
		
		List<Blog> s=blogService.viewAllBlogs();
		System.out.println(s);
			return new ResponseEntity<List<Blog>>(s, HttpStatus.OK);
		
	}
}
