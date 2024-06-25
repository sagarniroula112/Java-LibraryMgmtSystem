package com.model;

public class Book {
    private int id;
    private String title;
    private String author;
    private String bookAvailabilityStatus;  // Available or not

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", bookAvailabilityStatus='" + bookAvailabilityStatus + '\'' +
                '}'+ "\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookAvailabilityStatus() {
        return bookAvailabilityStatus;
    }

    public void setBookAvailabilityStatus(String bookAvailabilityStatus) {
        this.bookAvailabilityStatus = bookAvailabilityStatus;
    }
}
