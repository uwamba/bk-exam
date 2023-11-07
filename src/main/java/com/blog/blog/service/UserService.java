package com.blog.blog.service;
import com.blog.blog.entity.UserEntity;
import com.blog.blog.repository.UserRepo;
import com.blog.blog.response.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class UserService {
	    @Autowired
	    private UserRepo userRepo; 
	  
	   
	    private ModelMapper mapper; 
	    @Autowired
	    private PasswordEncoder passwordEncoder;
	    
	    @Autowired
	    private AuthenticationManager authenticationManager;
	    
	    public boolean login;
	    
	   
	    public UserResponse getUserById(int id) { 
	        UserEntity user = userRepo.getUserEntityById(id) ;
	        UserResponse userResponse = mapper.map(user,UserResponse.class); 
	        return userResponse; 
	    }
	    
	    //save user details in database
	    public UserEntity addUser(UserEntity user){
			return userRepo.save(user);
		}
	    
	    
	    
	    /*
	    public LoginMessage  loginUser(UserResponse response) {
	        UserEntity user = userRepo.findByEmail(response.getEmail());
	        if (user != null) {
	            String password = response.getPassword();
	            String encodedPassword = user.getPassword();
	            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
	            if (isPwdRight) {
	                Optional<UserEntity> user1 = userRepo.findOneByEmailAndPassword(response.getEmail(), encodedPassword);
	                if (user1.isPresent()) {
	                	System.out.println(response.getEmail());
	                	System.out.println(encodedPassword);
	                	
	                		UsernamePasswordAuthenticationToken request = new UsernamePasswordAuthenticationToken(
	                				response.getEmail(), encodedPassword);
	                		System.out.println(request.toString());
	                		
	                	  
	                         SecurityContextHolder.getContext().setAuthentication(request);
	                	
	                    return new LoginMessage("Login Success", true);
	                    
	                } else {
	                    return new LoginMessage("Login Failed", false);
	                }
	            } else {
	                return new LoginMessage("password Not Match", false);
	            }
	        }else {
	            return new LoginMessage("Email not exits", false);
	        }
	    }
	*/
	    
	    
}
