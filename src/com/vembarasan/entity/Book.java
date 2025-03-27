package com.vembarasan.entity;

import com.vembarasan.enums.BookStatus;
import com.vembarasan.enums.Genre;

public class Book {

   public static int id = 1;
   private int bookId = id++;
   private String title;
   private String author;
   private Genre genre;
   private BookStatus availabilityStatus;


    public Book() {}


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
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

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public BookStatus getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(BookStatus availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }


    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre=" + genre +
                ", availabilityStatus=" + availabilityStatus +
                '}';
    }
}
