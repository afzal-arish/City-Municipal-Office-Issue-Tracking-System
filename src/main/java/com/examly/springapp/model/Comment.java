package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Comment {

    @Id
    private Long id;

    private String content;

    public Comment() {}

    public Comment(String content, Long id) {
        this.content = content;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
