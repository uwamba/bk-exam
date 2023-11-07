package com.blog.blog.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.blog.entity.Comment;
import com.blog.blog.entity.Like;
import com.blog.blog.repository.LikeRepo;
import com.blog.blog.response.LikeResponse;


import java.util.List;
import java.util.Optional; 
@Service
public class LikeService {
	 @Autowired
	    private LikeRepo likeRepo; 
	  
	 
	    private ModelMapper mapper; 
	  
	    public LikeResponse getLikeById(int id) { 
	        Optional<Like> like = likeRepo.findById(id); 
	        LikeResponse likeResponse = mapper.map(like,LikeResponse.class); 
	        return likeResponse; 
	    } 
	    public Like addLike(Like like){
			return likeRepo.save(like);
		}
	  //get user posts
	   
	    public List<Like> getPostlike(String postId) {
	    	return likeRepo.getPostLike(postId) ;
	       
	    }
}
