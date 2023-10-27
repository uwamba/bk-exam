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

import com.blog.blog.entity.Post;
import com.blog.blog.entity.UserEntity;
import com.blog.blog.repository.PostRepo;
import com.blog.blog.repository.UserRepo;
import com.blog.blog.response.PostResponse;
import com.blog.blog.response.UserResponse;
import com.blog.blog.service.PostService;
import com.blog.blog.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class PostController {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserService userService;
	@Autowired
	
	 private UserRepo repo;
	 @Autowired
	 private PostRepo postRepository;
	 
	 public PostService postService;
	 public PostController(PostService postService) {
	        this.postService = postService;
	    }
	 
	//get post by id 
	@GetMapping("/post/{id}")
	private ResponseEntity<PostResponse> getPostDetails(@PathVariable("id") int id, HttpServletRequest headerRequest) {
	 
	String authorizationHeader = headerRequest.getHeader("Authorization");
	 ResponseEntity<PostResponse> resp=null;
	 String username, password;
	 PostResponse resEntity = null;
        if (authorizationHeader != null && authorizationHeader.startsWith("Basic ")) {
            String base64Credentials = authorizationHeader.substring(6);
            String credentials = new String(java.util.Base64.getDecoder().decode(base64Credentials));
            String[] usernameAndPassword = credentials.split(":");

            if (usernameAndPassword.length == 2) {
                 username = usernameAndPassword[0];
                 password = usernameAndPassword[1];
                 UserEntity user = repo.getUserEntityByEmail(username);
                if(user!=null) {
	                if(passwordEncoder.matches(password, user.getPassword())) {
	                	resEntity=postService.getPostById(id);
	                	resp=new ResponseEntity<PostResponse>(resEntity, HttpStatus.ACCEPTED);
	                }else {
	                	resp=new ResponseEntity<PostResponse>(resEntity, HttpStatus.FORBIDDEN);	
	                }
                
            }else {
            	resp=new ResponseEntity<PostResponse>(resEntity, HttpStatus.FORBIDDEN);	
            }
        }
        }
		return resp;
      
	}
// get one post per user
	

	@GetMapping("/post/user/{userId}")
    public ResponseEntity<List<Post>> getAllpost(@PathVariable("userId") String userId, HttpServletRequest headerRequest){
		String authorizationHeader = headerRequest.getHeader("Authorization");
		ResponseEntity<List<Post>> resp=null;
		 String username, password;
		 Post post=null;
	        if (authorizationHeader != null && authorizationHeader.startsWith("Basic ")) {
	            String base64Credentials = authorizationHeader.substring(6);
	            String credentials = new String(java.util.Base64.getDecoder().decode(base64Credentials));
	            String[] usernameAndPassword = credentials.split(":");

	            if (usernameAndPassword.length == 2) {
	                 username = usernameAndPassword[0];
	                 password = usernameAndPassword[1];
	                 UserEntity user = repo.getUserEntityByEmail(username);
	                if(user!=null) {
		                if(passwordEncoder.matches(password, user.getPassword())) {
		                
		                	List<Post> posts = postService.getUserPost(userId);
		                	
		                	resp=new ResponseEntity<>(posts, HttpStatus.OK);
		                }else {
		                	
		                }
	                
	            }else {
	            	
	            }
	        }
	        }
			
	        return resp;
	   
	
    }

// add new post in database
	
	@PostMapping("/post/add")
	private ResponseEntity<Post> setPostDetails(@RequestBody PostResponse newPost, HttpServletRequest headerRequest) {
	 
	String authorizationHeader = headerRequest.getHeader("Authorization");
	 ResponseEntity<Post> resp=null;
	 String username, password;
	 PostResponse resEntity = null;
        if (authorizationHeader != null && authorizationHeader.startsWith("Basic ")) {
            String base64Credentials = authorizationHeader.substring(6);
            String credentials = new String(java.util.Base64.getDecoder().decode(base64Credentials));
            String[] usernameAndPassword = credentials.split(":");
            Post generatedPost = null;
            if (usernameAndPassword.length == 2) {
                 username = usernameAndPassword[0];
                 password = usernameAndPassword[1];
                 UserEntity user = repo.getUserEntityByEmail(username);
                if(user!=null) {
	                if(passwordEncoder.matches(password, user.getPassword())) {
	                	
	                	Post post = new Post();
	            		
	            		BeanUtils.copyProperties(newPost, post);
	            		generatedPost=postService.addPost(post);
	       
	                	resp=new ResponseEntity<Post>(generatedPost, HttpStatus.ACCEPTED);
	                }else {
	                	resp=new ResponseEntity<Post>(generatedPost, HttpStatus.FORBIDDEN);	
	                }
                
            }else {
            	resp=new ResponseEntity<Post>(generatedPost, HttpStatus.FORBIDDEN);	
            }
        }
        }
		return resp;
      
	}



}

