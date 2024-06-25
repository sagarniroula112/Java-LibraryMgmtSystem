package com.view;

import com.model.Book;
import com.service.BookService;
import com.service.BookServiceImpl;

import java.util.List;
import java.util.Scanner;

public class BookView {
    public void showMenu() {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";  // Red color
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while(!exit){
            System.out.println();
            System.out.println("--------------------- BOOK MENU ------------------------");
            System.out.println("Choose among options:: ");
            System.out.println();
            System.out.println("1. Add a Book.");
            System.out.println("2. Show All Books.");
            System.out.println("3. Remove a Book.");
            System.out.println("4. EXIT.");
            System.out.println();
            System.out.print("Enter your choice::  ");
            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                    addBook();
                    break;

                case 2:
                    getAllBooks();
                    break;

                case 3:
                    deleteBook();
                    break;

                case 4:
                    exit = true;
                    System.out.println(ANSI_RED + "Exiting the book menu...." + ANSI_RESET);
                    break;

                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }



    }

    static void addBook() {
        BookService bService = new BookServiceImpl();

        char flag = 'y';
        Scanner sc = new Scanner(System.in);

        do {
            Book b = new Book();

            System.out.print("Enter book title:: ");
            b.setTitle(sc.nextLine());
            System.out.print("Enter book author:: ");
            b.setAuthor(sc.nextLine());
            System.out.print("Enter book availability:: ");
            b.setBookAvailabilityStatus(sc.nextLine());

            bService.addBook(b);

            System.out.println("Do you want to add more [y/n]? ");
            flag = sc.nextLine().charAt(0);
        } while (flag == 'y');
    }

    static void deleteBook() {
        BookService bService = new BookServiceImpl();

        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter book ID to delete:: ");
        int id = sc.nextInt();
        bService.deleteBook(id);
    }

    static void getAllBooks(){
        BookService bService = new BookServiceImpl();

        List<Book> books = bService.getAllBooks();
        System.out.println(books);
    }
}
