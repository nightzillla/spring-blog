package com.codeup.springblog.models;

public class Post {
    private String title;
    private String body;

    // GETTERS
    public String getTitle(){
       return title;
   }
    // SETTERS
    public void setTitle(String title) {
        this.title = title;
    }

    // GETTERS
    public  String getBody(){
       return body;
   }
    public void setBody(){}
    // SETTERS
    public void setBody(String body) {
        this.body = body;
    }
    public Post (){
    }
    public Post (String title, String body){
       this.title = title;
       this.body = body;
    }

}
