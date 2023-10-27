package com.blog.blog.response;

import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class UserResponse { 
	
 
    private int id; 
  
    private String firstName; 
     
    private String lastName; 
  

    private String email; 
    
 
    private String phone; 

    
    private String password;
  
    
  
    public int getId() { 
        return id; 
    } 
  
    public void setId(int id) { 
        this.id = id; 
    } 
  
    public String getFistName() { 
        return firstName; 
    } 
  
    public void setFistName(String firstName) { 
        this.firstName = firstName; 
    } 
    public String getLastName() { 
        return lastName; 
    } 
  
    public void setLastName(String lastName) { 
        this.lastName = lastName; 
    }
    public String getPhone() { 
        return phone; 
    } 
  
    public void setPhone(String phone) { 
        this.phone = phone; 
    }
  
    public String getEmail() { 
        return email; 
    } 
  
    public void setEmail(String email) { 
        this.email = email; 
    } 
    public String getPassword() { 
        return password; 
    } 
  
    public void setPassword(String password) { 
        this.password = password; 
    } 
    
  
   
} 