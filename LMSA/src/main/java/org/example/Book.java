package org.example;

import java.util.List;

public class Book {
    private String ISBN;
    private String title;
    private String subject;
    private String publisher;
    private String language;
    private Integer pages;
    private List<AuthorPage> authorPages;

    public Book(String ISBN, String title, String subject, String publisher, String language, Integer pages) {
        this.ISBN = ISBN;
        this.title = title;
        this.subject = subject;
        this.publisher = publisher;
        this.language = language;
        this.pages = pages;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }
}