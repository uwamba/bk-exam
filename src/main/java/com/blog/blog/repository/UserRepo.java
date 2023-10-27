package com.blog.blog.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blog.blog.entity.UserEntity; 
@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> { 
	Optional<UserEntity> findOneByEmailAndPassword(String email, String password);
	
	@Query("select u from UserEntity u where u.email = :email")
	UserEntity getUserEntityByEmail(@Param("email") String email);
	
	@Query("select u from UserEntity u where u.id = :id")
	UserEntity getUserEntityById(@Param("id") int id);
	
}



