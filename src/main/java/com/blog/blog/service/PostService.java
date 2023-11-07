package com.blog.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.blog.blog.entity.Post;
import com.blog.blog.entity.UserEntity;
import com.blog.blog.repository.PostRepo;
import com.blog.blog.response.PostResponse;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional; 
@Service
public class PostService {
	    @Autowired
	    private PostRepo postRepo; 
	   
	   
	    private ModelMapper mapper; 
	  
	    public PostResponse getPostById(int id) { 
	        Optional<Post> post = postRepo.findById(id); 
	        PostResponse postResponse = mapper.map(post,PostResponse.class); 
	        return postResponse; 
	    }
	    public Post addPost(Post post){
			return postRepo.save(post);
		}
	  //get user posts
	   
	    public List<Post> getUserPost(String UserId) {
	    	return postRepo.getPostByUserId(UserId); 
	       
	    }
	    
	    
}
