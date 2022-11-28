package com.codeup.springblog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    // 1. Create a User class, with (at least) fields for id, username, email, and password.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50, unique = true)
    private String username;

    @Column(nullable = false, length = 60)
    private String email;

    @Column(nullable = false)
    private String password;

    public User() {
    }

    public User(long id, String email, String password, List<Post> posts) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.posts = posts;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;
}


