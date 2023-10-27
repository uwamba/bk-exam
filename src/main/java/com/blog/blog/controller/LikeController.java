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
import com.blog.blog.entity.Like;
import com.blog.blog.entity.Post;
import com.blog.blog.entity.UserEntity;
import com.blog.blog.repository.LikeRepo;
import com.blog.blog.repository.PostRepo;
import com.blog.blog.repository.UserRepo;
import com.blog.blog.response.CommentResponse;
import com.blog.blog.response.LikeResponse;
import com.blog.blog.response.PostResponse;
import com.blog.blog.response.UserResponse;
import com.blog.blog.service.CommentService;
import com.blog.blog.service.LikeService;
import com.blog.blog.service.PostService;
import com.blog.blog.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class LikeController {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserService userService;
	@Autowired
	
	 private UserRepo userRepo;
	 @Autowired
	 private LikeRepo likeRepository;
	 
	 public LikeService likeService;
	 public LikeController(LikeService likeService) {
	        this.likeService = likeService;
	    }
	 

	// add new post in database
	
		@PostMapping("/post/like/add")
		private ResponseEntity<Like> setLikeDetails(@RequestBody LikeResponse newLike, HttpServletRequest headerRequest) {
		 
		String authorizationHeader = headerRequest.getHeader("Authorization");
		 ResponseEntity<Like> resp=null;
		 String username, password;
		 LikeResponse resEntity = null;
	        if (authorizationHeader != null && authorizationHeader.startsWith("Basic ")) {
	            String base64Credentials = authorizationHeader.substring(6);
	            String credentials = new String(java.util.Base64.getDecoder().decode(base64Credentials));
	            String[] usernameAndPassword = credentials.split(":");
	            Like generatedLike = null;
	            if (usernameAndPassword.length == 2) {
	                 username = usernameAndPassword[0];
	                 password = usernameAndPassword[1];
	                 UserEntity user = userRepo.getUserEntityByEmail(username);
	                if(user!=null) {
		                if(passwordEncoder.matches(password, user.getPassword())) {
		                	
		                	Like like = new Like();
		            		
		            		BeanUtils.copyProperties(newLike, like);
		            		generatedLike=likeService.addLike(like);
		       
		                	resp=new ResponseEntity<Like>(generatedLike, HttpStatus.ACCEPTED);
		                }else {
		                	resp=new ResponseEntity<Like>(generatedLike, HttpStatus.FORBIDDEN);	
		                }
	                
	            }else {
	            	resp=new ResponseEntity<Like>(generatedLike, HttpStatus.FORBIDDEN);	
	            }
	        }
	        }
			return resp;
	      
		}
		//get comment by post id
		
		//get all post 
		@GetMapping("/post/like/{postId}")
		public ResponseEntity<List<Like>> getAllPostLike(@PathVariable("postId") String postId, HttpServletRequest headerRequest){
			String authorizationHeader = headerRequest.getHeader("Authorization");
			ResponseEntity<List<Like>> resp=null;
			 String username, password;
			 Like like=null;
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
			                
			                	List<Like> likes = likeService.getPostlike(postId);
			                	
			                	resp=new ResponseEntity<>(likes, HttpStatus.OK);
			                }else {
			                	
			                }
		                
		            }else {
		            	
		            }
		        }
		        }
				
		        return resp;
		   
		
	    }


}
