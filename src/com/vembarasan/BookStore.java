package com.vembarasan;

import com.vembarasan.entity.Book;
import com.vembarasan.enums.BookStatus;
import com.vembarasan.enums.Genre;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class BookStore {
    public HashMap<Integer, Book> books = new HashMap<>();



    public void addBook( String bookTitle,String authorName, Genre bookGenre){

        // Create new book
        Book book = new Book();
        book.setTitle(bookTitle);
        book.setAuthor(authorName);
        book.setAvailabilityStatus(BookStatus.AVAILABLE); // Initially book status is Available
        book.setGenre(bookGenre);
        books.put(book.getBookId(), book);

        System.out.println("Book added Successfully.");
        System.out.println(book);
        System.out.println();
    }


    public void findBooksByIdOrTitle(String idOrTitle){

        Optional<Book> getBook = Optional.empty();
        try {
            int id = Integer.parseInt(idOrTitle);
            getBook = Optional.ofNullable(books.get(id));
        }
        catch (NumberFormatException e){
            System.out.println("Input is not an Integer. Lets find Book by title");
            getBook = books.values().stream()
                    .filter(b -> b.getTitle().equalsIgnoreCase(idOrTitle))
                    .findFirst();
        }

        getBook.ifPresentOrElse(System.out::println, () -> System.out.println("Book not found"));

    }


    public  void displayAllBooks() {

        if (books.isEmpty()){
            System.out.println("The library currently has no books. Please add some books. ");
            return;
        }

        for (Map.Entry<Integer, Book> book : books.entrySet() ){
            System.out.println(book.getValue());
        }
    }


    public void updateBook(int id, String authorName, String bookTitle, BookStatus bookStatus){

        Book book = findBookById(id);
        if (book == null) {
            System.out.println("Book not found");
            return;
        }

        book.setAuthor(authorName);
        book.setTitle(bookTitle);
        book.setAvailabilityStatus(bookStatus);
        System.out.println("Book Updated Successfully.");

    }


    public Book findBookById(int bookId){
         return books.get(bookId);
    }


    public void removeBook(int id) {

        Book book = findBookById(id);
        if (book == null){
            System.out.println("Book not found.");
            return;
        }

        books.remove(id); // remove books
        System.out.println("Book removed successfully.");

    }
}
