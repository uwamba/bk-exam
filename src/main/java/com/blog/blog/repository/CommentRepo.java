package com.blog.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blog.blog.entity.Comment;
import com.blog.blog.entity.Post; 
@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer> { 
	@Query("select u from Comment u where u.postId = :postId")
	List<Comment> getPostComment(@Param("postId") String postId);
	
}

