package com.blog.blog.config;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.blog.blog.entity.UserEntity;
import com.blog.blog.repository.UserRepo;

@Component
public class CustomAuthenticator {
	private PasswordEncoder encoder;
	UserRepo repository;

	public boolean isAuthenticated(String username, String password) {

		return true;

	}
}
