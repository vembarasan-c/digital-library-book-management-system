package com.vembarasan;

import com.vembarasan.entity.Book;
import com.vembarasan.enums.BookStatus;
import com.vembarasan.enums.Genre;

import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) {

        System.out.println("Digital Library Book Management System.");
        BookStore bookStore = new BookStore();
        Scanner input = new Scanner(System.in);
        boolean loop = true;

        while (loop){

            System.out.println();
            System.out.println("1. Add New Book \n2. Show all books \n3. Search a book \n4. Update Book   \n5. Delete Book  \n6. Exit...");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    // Add new book
                    System.out.println("Add new Book. Enter correct details below the inputs");

                    System.out.println("Enter Book title: ");
                    String bookTitle = input.next();

                    if (bookTitle.isEmpty()){
                        System.out.println("Book title cannot be empty!");
                        break;
                    }

                    System.out.println("Enter Book Author name: ");
                    String authorName = input.next();

                    if (authorName.isEmpty()){
                        System.out.println("author name cannot be empty!");
                        break;
                    }

                    System.out.println("Enter the book genre ( FICTION,  NON_FICTION, FANTASY, SCIENCE,, BIOGRAPHY, MYSTERY,  HISTORY)");
                    String statusInput = input.next().toUpperCase();

                    try {
                        Genre bookGenre = Genre.valueOf(statusInput);
                        bookStore.addBook(bookTitle, authorName, bookGenre); // add new book
                    }catch (IllegalArgumentException e ){
                        System.out.println("Invalid Status! Please enter valid book genre from the given options");
                    }

                    break;


                case 2:
                    // Display all books
                    bookStore.displayAllBooks();
                    break;

                case 3:
                    // Search book by id or title.
                    System.out.println("Enter Book id -> (Integer) or Title -> (String): ");
                    String idOrTitle = input.next();
                    bookStore.findBooksByIdOrTitle(idOrTitle);

                    break;

                case 4:
                    // Update book
                    System.out.println("Update books details. ");

                    System.out.println("Enter Book id: ");
                    int id  = input.nextInt();
                    Book book = bookStore.findBookById(id);
                    if (book ==  null) {
                        System.out.println("Book not found!");
                        break;
                    }

                    System.out.println("Enter author name:");
                    String name = input.next();

                    System.out.println("Enter book title: ");
                    String title = input.next();

                    System.out.println("Enter the book status (AVAILABLE, CHECKED_OUT)");
                    String bookStatus = input.next().toUpperCase();

                    try {
                        BookStatus status = BookStatus.valueOf(bookStatus);
                        bookStore.updateBook(id, name, title, status); // update book details

                    }catch (IllegalArgumentException e){
                        System.out.println("Invalid Status! Please enter valid book status from the given options");
                    }
                    break;


                case 5:

                    System.out.println("Enter book id:");
                    int bookId = input.nextInt();
                    bookStore.removeBook(bookId);
                    break;

                case 6:

                    System.out.println("Exit from this application.");
                    loop = false;
                    break;


                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }



        }

    }


}
