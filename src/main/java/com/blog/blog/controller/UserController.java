package com.blog.blog.controller;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.blog.config.CustomAuthenticator;
import com.blog.blog.entity.UserEntity;
import com.blog.blog.repository.UserRepo;
import com.blog.blog.response.UserResponse;
import com.blog.blog.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	private UserResponse user;
	@Autowired
	private CustomAuthenticator auth;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepo repo;


	
    // get single user
	@GetMapping("/user/{id}")
		private ResponseEntity<UserResponse> getUserDetails(@PathVariable("id") int id, HttpServletRequest headerRequest) {
		 
		String authorizationHeader = headerRequest.getHeader("Authorization");
		 ResponseEntity<UserResponse> resp=null;
		 String username, password;
		 UserResponse resEntity = null;
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
		                	resEntity=userService.getUserById(id);
		                	resp=new ResponseEntity<UserResponse>(resEntity, HttpStatus.CREATED);
		                }else {
		                	resp=new ResponseEntity<UserResponse>(resEntity, HttpStatus.BAD_REQUEST);		
		                }
	                
	            }else {
	            	resp=new ResponseEntity<UserResponse>(resEntity, HttpStatus.BAD_REQUEST);	
	            }
	        }
	        }
			return resp;
	      
		}


	// register new user in database
	@PostMapping("/signup")
	public ResponseEntity<UserEntity> addUser(@RequestBody UserResponse newUser) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		System.out.println(authentication.getName().toString());
		UserEntity user = new UserEntity();

		UserEntity generatedUser = null;

		BeanUtils.copyProperties(newUser, user);
		generatedUser = userService.addUser(user);
		return new ResponseEntity<UserEntity>(generatedUser, HttpStatus.CREATED);
	}


	

}
