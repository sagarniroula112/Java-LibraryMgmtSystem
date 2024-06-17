package com.view;

import com.model.Book;
import com.service.BookServices;
import com.service.BookServicesImpl;

import java.util.Scanner;
import java.util.List;

public class BookView {
    public static void main(String[] args) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";  // Red color
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while(!exit){
            System.out.println();
            System.out.println("--------------------- MENU ------------------------");
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
                    System.out.println(ANSI_RED + "Exiting the program." + ANSI_RESET);
                    break;

                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }



    }

    static void addBook() {
        BookServices bService = new BookServicesImpl();

        char flag = 'y';
        Scanner sc = new Scanner(System.in);

        do {
            Book b = new Book();

            System.out.println("Enter book title:: ");
            b.setTitle(sc.nextLine());
            System.out.println("Enter book author:: ");
            b.setAuthor(sc.nextLine());
            System.out.println("Enter book availability:: ");
            b.setBookAvailabilityStatus(sc.nextLine());

            bService.addBook(b);

            System.out.println("Do you want to add more [y/n]? ");
            flag = sc.nextLine().charAt(0);
        } while (flag == 'y');
    }

    static void deleteBook() {
        BookServices bService = new BookServicesImpl();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter book ID to delete:: ");
        int id = sc.nextInt();
        bService.removeBook(id);
    }

    static void getAllBooks(){
        BookServices bService = new BookServicesImpl();

        List<Book> books = bService.getAllBooks();
        System.out.println(books);
    }
}
