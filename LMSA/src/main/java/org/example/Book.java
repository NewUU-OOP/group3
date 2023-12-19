package org.example;

public class Book {
    private String ISBN;
    private String title;
    private String subject;
    private String publisher;
    private String language;
    private String author;
    private Rack placedAt;
    private BookFormat format;
    private BookStatus status;

    public Book(String ISBN, String title, String subject, String publisher,
                String language, String author, Rack placedAt, BookFormat format, BookStatus status) {
        this.ISBN = ISBN;
        this.title = title;
        this.subject = subject;
        this.publisher = publisher;
        this.language = language;
        this.author = author;
        this.placedAt = placedAt;
        this.format = format;
        this.status = status;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getSubject() {
        return subject;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getLanguage() {
        return language;
    }

    public String getAuthor() {
        return author;
    }

    public Rack getPlacedAt() {
        return placedAt;
    }

    public BookFormat getFormat() {
        return format;
    }

    public BookStatus getStatus() {
        return status;
    }
}