package com.example.demo.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.demo.Dao.BlogDao;
import com.example.demo.Model.Blog;

@Component
public class BlogDaoImpl implements BlogDao{

	@Autowired
	JdbcTemplate JdbcTemplate;
	
	@Override
	public Blog getBlog(int blogId) {
		Blog blog;
		try {
			
		blog=JdbcTemplate.query("SELECT * FROM blogs WHERE Blog_ID=?",new ResultSetExtractor<Blog>() {

			@Override
			public Blog extractData(ResultSet rs) throws SQLException, DataAccessException {
				rs.next();
				Blog b=new Blog();
				b.setBlog_ID(rs.getInt("Blog_ID"));
				b.setBlog_Title(rs.getString("Blog_Title"));
				b.setDescription(rs.getString("Description"));
				return b;
			}
			
		},blogId);
		return blog;
		}
		catch(Exception e) {
			return null;
		}
		
	}

	@Override
	public Blog insertBlog(Blog blog) {
		int flag;
		try {
			System.out.println(blog);
		flag=JdbcTemplate.update("insert into blogs(Blog_Title,Description) values(?,?)",blog.getBlog_Title(),blog.getDescription() );
		if(flag>0)
			return blog;
		}
		catch(Exception e) {
			
			return null;
		}
		
		return null;
	}
	
	
	public Blog updateBlog(Blog blog) {
		int flag;
		try {
			
			flag=JdbcTemplate.update("UPDATE blogs SET Blog_Title=?,Description=? WHERE Blog_ID=?", blog.getBlog_Title(),blog.getDescription(),blog.getBlog_ID());
			if(flag>0) {
				return blog;
			}
			
		}
		catch(Exception e) {
			
			return null;
		}
		return null;
	}

	@Override
	public Boolean deleteBlog(int Blog_ID) {
		int flag;
		try {
			flag=JdbcTemplate.update("DELETE FROM blogs WHERE Blog_ID=?", Blog_ID);
			if(flag>0)
				return true;
		}
		catch (Exception e) {
			return false;
		}
		return false;
	}

	@Override
	public List<Blog> viewAllBlogs() {
		List<Blog> blogs;
		try {
			blogs=JdbcTemplate.query("select * from blogs", new RowMapper<Blog>() {

				@Override
				public Blog mapRow(ResultSet rs, int rowNum) throws SQLException {
					Blog b=new Blog();
					b.setBlog_ID(rs.getInt("Blog_ID"));
					b.setBlog_Title(rs.getString("Blog_Title"));
					b.setDescription(rs.getString("Description"));
					return b;
				}
				
			});
			return blogs;
		}
		catch (Exception e) {
			return null;
		}
		
	}

}
