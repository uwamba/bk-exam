package com.blog.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blog.blog.entity.Post;
import com.blog.blog.entity.UserEntity;
import com.blog.blog.response.PostResponse; 
@Repository
public interface PostRepo extends JpaRepository<Post, Integer> { 
	
	
	
	@Query("select u from Post u where u.userId = :userId")
	List<Post> getPostByUserId(@Param("userId") String userId);
	
	

}

