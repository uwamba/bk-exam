package com.blog.blog.entity;

import jakarta.persistence.*; 

@Entity
@Table(name = "liking") 
public class Like { 
	  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id") 
    private int id; 
  
    @Column(name = "is_like") 
    private String isLike; 
    
  
    @Basic(optional = false)
    @Column(name = "date_time", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private String dateTime; 
    
    @Column(name = "post_id") 
    private String postId; 
    
    @Column(name = "user_id") 
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
    public void setUserId(String userId) { 
        this.userId = userId; 
    } 
    public String getUserId() { 
        return userId; 
    } 
  
   
    
    public String getDateTime() { 
        return dateTime; 
    } 
  
    public void setDateTime(String dateTime) { 
        this.dateTime = dateTime; 
    }
  
  
   
} 