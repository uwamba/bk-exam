package com.blog.blog.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.blog.entity.Comment;
import com.blog.blog.entity.Post;
import com.blog.blog.entity.UserEntity;
import com.blog.blog.repository.PostRepo;
import com.blog.blog.repository.UserRepo;
import com.blog.blog.response.CommentResponse;
import com.blog.blog.response.PostResponse;
import com.blog.blog.response.UserResponse;
import com.blog.blog.service.CommentService;
import com.blog.blog.service.PostService;
import com.blog.blog.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class CommentController {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserService userService;
	@Autowired
	
	 private UserRepo userRepo;
	 @Autowired
	 private PostRepo postRepository;
	 
	 public CommentService commentService;
	 public CommentController(CommentService commentService) {
	        this.commentService = commentService;
	    }
	 

	// add new post in database
	
		@PostMapping("/post/comment/add")
		private ResponseEntity<Comment> setPostDetails(@RequestBody CommentResponse newComment, HttpServletRequest headerRequest) {
		 
		String authorizationHeader = headerRequest.getHeader("Authorization");
		 ResponseEntity<Comment> resp=null;
		 String username, password;
		 CommentResponse resEntity = null;
	        if (authorizationHeader != null && authorizationHeader.startsWith("Basic ")) {
	            String base64Credentials = authorizationHeader.substring(6);
	            String credentials = new String(java.util.Base64.getDecoder().decode(base64Credentials));
	            String[] usernameAndPassword = credentials.split(":");
	            Comment generatedComment = null;
	            if (usernameAndPassword.length == 2) {
	                 username = usernameAndPassword[0];
	                 password = usernameAndPassword[1];
	                 UserEntity user = userRepo.getUserEntityByEmail(username);
	                if(user!=null) {
		                if(passwordEncoder.matches(password, user.getPassword())) {
		                	
		                	Comment comm = new Comment();
		            		
		            		BeanUtils.copyProperties(newComment, comm);
		            		generatedComment=commentService.addComment(comm);
		       
		                	resp=new ResponseEntity<Comment>(generatedComment, HttpStatus.ACCEPTED);
		                }else {
		                	resp=new ResponseEntity<Comment>(generatedComment, HttpStatus.FORBIDDEN);	
		                }
	                
	            }else {
	            	resp=new ResponseEntity<Comment>(generatedComment, HttpStatus.FORBIDDEN);	
	            }
	        }
	        }
			return resp;
	      
		}
		//get comment by post id
		
		//get all post 
		@GetMapping("/post/comment/{postId}")
		public ResponseEntity<List<Comment>> getAllUserPostt(@PathVariable("postId") String postId, HttpServletRequest headerRequest){
			String authorizationHeader = headerRequest.getHeader("Authorization");
			ResponseEntity<List<Comment>> resp=null;
			 String username, password;
			 Comment comment=null;
		        if (authorizationHeader != null && authorizationHeader.startsWith("Basic ")) {
		            String base64Credentials = authorizationHeader.substring(6);
		            String credentials = new String(java.util.Base64.getDecoder().decode(base64Credentials));
		            String[] usernameAndPassword = credentials.split(":");

		            if (usernameAndPassword.length == 2) {
		                 username = usernameAndPassword[0];
		                 password = usernameAndPassword[1];
		                 UserEntity user = userRepo.getUserEntityByEmail(username);
		                if(user!=null) {
			                if(passwordEncoder.matches(password, user.getPassword())) {
			                
			                	List<Comment> comments = commentService.getPostComment(postId);
			                	
			                	resp=new ResponseEntity<>(comments, HttpStatus.OK);
			                }else {
			                	
			                }
		                
		            }else {
		            	
		            }
		        }
		        }
				
		        return resp;
		   
		
	    }


}
