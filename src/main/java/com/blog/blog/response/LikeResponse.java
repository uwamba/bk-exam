package com.blog.blog.response;


public class LikeResponse { 

    private int id; 
  
    private String isLike; 
    private String dateTime; 
    private String postId; 
    private String userId; 
    

    public int getId() { 
        return id; 
    } 
  
    public void setId(int id) { 
        this.id = id; 
    } 
  
    public String getIsLike() { 
        return isLike; 
    } 
  
    public void setIsLike(String isLike) { 
        this.isLike = isLike; 
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