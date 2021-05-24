package com.codeup.tier1hire.models;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="resumes")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = true)
    private String title;

    @Column(nullable = true)
    private Date createdAt;

    @Column(nullable = true)
    private String description;

    @Column(nullable = true)
    @Value("${file-upload-path}")
    private String filePath;

    @ManyToOne
    private User user;

//    Constructors

    public Resume() {
    }

    public Resume(String title, Date date, String description, String filePath, User user) {
        this.title = title;
        this.createdAt = date;
        this.description = description;
        this.filePath = filePath;
        this.user = user;
    }

//    Getters and Setters

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(long id) {
        this.id = id;
    }
}

