package com.blog.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.blog.entity.Comment;
import com.blog.blog.repository.CommentRepo;
import com.blog.blog.response.CommentResponse;


import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional; 
@Service
public class CommentService {
	 @Autowired
	    private CommentRepo commentRepo; 
	  
	    @Autowired
	    private ModelMapper mapper; 
	  
	    public CommentResponse getCommentById(int id) { 
	        Optional<Comment> comment = commentRepo.findById(id); 
	        CommentResponse commentResponse = mapper.map(comment,CommentResponse.class); 
	        return commentResponse; 
	    } 
	    
	    public Comment addComment(Comment comment){
			return commentRepo.save(comment);
		}
	  //get user posts
	   
	    public List<Comment> getPostComment(String postId) {
	    	return commentRepo.getPostComment(postId) ;
	       
	    }
}
