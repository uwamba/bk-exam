package com.blog.blog.response;

import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class CommentResponse { 
	  

    private int id; 
    private String comment; 
    private String dateTime; 
    private String postId; 
    private String userId; 
    
   
  
    
  
    public int getId() { 
        return id; 
    } 
  
    public void setId(int id) { 
        this.id = id; 
    } 
  
    public String getComment() { 
        return comment; 
    } 
  
    public void setCommenty(String comment) { 
        this.comment = comment; 
    }
    public String getPostId() { 
        return postId; 
    } 
  
    public void setPostId(String postId) { 
        this.postId = postId; 
    } 
    public String getUserId() { 
        return userId; 
    } 
  
    public void setUserId(String userId) { 
        this.userId = userId; 
    } 
    
    public String getDateTime() { 
        return dateTime; 
    } 
  
    public void setDateTime(String dateTime) { 
        this.dateTime = dateTime; 
    }
  
  
   
} 