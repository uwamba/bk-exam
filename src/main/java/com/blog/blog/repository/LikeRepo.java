package com.blog.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blog.blog.entity.Comment;
import com.blog.blog.entity.Like;
@Repository
public interface LikeRepo extends JpaRepository<Like, Integer> { 
	@Query("select u from Like u where u.postId = :postId")
	List<Like> getPostLike(@Param("postId") String postId);
}

