package com.joshuamatos.Crud2.books;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime publishDate;

    public Book(long id, String name, LocalDateTime publishDate) {
        this.id = id;
        this.name = name;
        this.publishDate = publishDate;
    }

    public Book(String name, LocalDateTime publishDate) {
        this.name = name;
        this.publishDate = publishDate;
    }

    public Book() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
    }
}