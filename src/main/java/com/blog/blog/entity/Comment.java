package com.blog.blog.entity;

import jakarta.persistence.*; 

@Entity
@Table(name = "comment") 
public class Comment { 
	  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id") 
    private int id; 
  
    @Column(name = "comment") 
    private String comment; 
    
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
  
    public String getComment() { 
        return comment; 
    } 
  
    public void setComment(String comment) { 
        this.comment = comment; 
    }
    public String getUserId() { 
        return userId; 
    } 
  
    public void setUserId(String userId) { 
        this.userId = userId; 
    }
    public String getPostId() { 
        return postId; 
    } 
  
    public void setPostId(String postId) { 
        this.postId = postId; 
    } 
    
    public String getDateTime() { 
        return dateTime; 
    } 
  
    public void setDateTime(String dateTime) { 
        this.dateTime = dateTime; 
    }
  
  
   
} 