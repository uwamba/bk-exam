package com.blog.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.blog.blog.service.UserService;
@Configuration
public class UserConfig {
	
	@Bean
     UserService user() { 
        return new UserService(); 
    }

    
    

}
