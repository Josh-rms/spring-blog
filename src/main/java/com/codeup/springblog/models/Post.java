package com.codeup.springblog.models;

import org.apache.catalina.User;

import javax.persistence.*;

@Entity
@Table(name = "po")
public class Post {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "text")
    private String body;

    @OneToOne
    private User user;

    //used to Create
    public Post(){
    }

    //used to Edit
    public Post(String title, String body, User user){
        this.title = title;
        this.body = body;
        this.user = user;
    }

    //used to Read
    public Post(long id, String title, String body, User user){
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
    }

    //Used to Delete
    public Post(long id){
        this.id = id;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getBody(){
        return body;
    }

    public void setBody(){
        this.body = body;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public void setUser(com.codeup.springblog.models.User userDB) {
    }
}
