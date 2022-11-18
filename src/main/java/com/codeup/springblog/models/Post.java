package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post {
    // this id is for the entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    // We are creating the columns
    @Column(nullable = false, length = 50)

    private String title;
    private String body;

//    private long id;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
//    public Post (String title, String body){
//       this.title = title;
//       this.body = body;
//    }

    public Post (long id,String title, String body){
        this.id = id;
        this.title = title;
        this.body = body;
    }

}
