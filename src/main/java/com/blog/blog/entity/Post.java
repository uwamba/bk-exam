package com.blog.blog.entity;
import jakarta.persistence.*; 

@Entity
@Table(name = "post") 
public class Post { 
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id") 
    private int id; 
  
    @Column(name = "body") 
    private String body; 
    
    @Column(name = "image_path") 
    private String imagePath; 
    
    @Basic(optional = false)
    @Column(name = "date_time", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private String dateTime; 
    
    @Column(name = "user_id") 
    private String userId; 
    
   
  
    
  
    public int getId() { 
        return id; 
    } 
  
    public void setId(int id) { 
        this.id = id; 
    } 
  
    public String getbody() { 
        return body; 
    } 
  
    public void setbody(String body) { 
        this.body = body; 
    } 
    public String  getImagePath() { 
        return imagePath; 
    } 
  
    public void setImagePath(String imagePath) { 
        this.imagePath = imagePath; 
    }
    public String getDateTime() { 
        return dateTime; 
    } 
  
    public void setDateTime(String dateTime) { 
        this.dateTime = dateTime; 
    }
    public String getUserId() { 
        return userId; 
    } 
  
    public void setUserId(String userId) { 
        this.userId = userId; 
    } 
  
  
   
} 