package com.ll.basic.article.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Article {
    @Id
    private long id;
    private String username;
    private String password;

}

