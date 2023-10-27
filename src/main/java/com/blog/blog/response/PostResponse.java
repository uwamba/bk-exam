package com.blog.blog.response;


 
public class PostResponse { 
  

    private int id; 
 
    private String body; 
    
 
    private String imagePath; 
  
 
    private String dateTime; 
    

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
  
    public void setImage(String imagePath) { 
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
  
    public void setUsertId(String userId) { 
        this.userId = userId; 
    } 
  
  
   
} 