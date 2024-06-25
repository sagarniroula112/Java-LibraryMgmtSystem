package com.view;

import com.model.Borrow;
import com.service.BorrowService;
import com.service.BorrowServiceImpl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BorrowView {
    public void showMenu() {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";  // Red color
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while(!exit){
            System.out.println();
            System.out.println("--------------------- BORROW MENU ------------------------");
            System.out.println("Choose among options:: ");
            System.out.println();
            System.out.println("1. Add a Borrow.");
            System.out.println("2. Show All Borrows.");
            System.out.println("3. Remove a Borrow.");
            System.out.println("4. EXIT.");
            System.out.println();
            System.out.print("Enter your choice::  ");
            int choice = sc.nextInt();
            System.out.println();
            switch(choice) {
                case 1:
                    addBorrow();
                    break;

                case 2:
                    getAllBorrow();
                    break;

                case 3:
                    deleteBorrow();
                    break;

                case 4:
                    exit = true;
                    System.out.println(ANSI_RED + "Exiting the borrow menu...." + ANSI_RESET);
                    break;

                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }



    }

    static void addBorrow() {
        BorrowService bService = new BorrowServiceImpl();

        char flag = 'y';
        Scanner sc = new Scanner(System.in);

        do {
            Borrow b = new Borrow();

            System.out.print("Enter memberID:: ");
            b.setMemberId(sc.nextInt());
            sc.nextLine(); // Consume the newline

            System.out.print("Enter bookID:: ");
            b.setBookId(sc.nextInt());
            sc.nextLine(); // Consume the newline

            System.out.print("Enter borrowDate(YYYY-MM-DD):: ");
            b.setBorrowDate(LocalDate.parse(sc.nextLine()));
            System.out.print("Enter returnDate(YYYY-MM-DD):: ");
            b.setReturnDate(LocalDate.parse(sc.nextLine()));
            b.setFine(0);

            bService.addBorrow(b);
            System.out.println();
            System.out.println("Do you want to add more [y/n]? ");
            flag = sc.nextLine().charAt(0);
        } while (flag == 'y');
    }

    static void deleteBorrow() {
        BorrowService bService = new BorrowServiceImpl();

        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter book ID to delete:: ");
        int id = sc.nextInt();
        bService.deleteBorrow(id);
    }

    static void getAllBorrow(){
        BorrowService bService = new BorrowServiceImpl();

        List<Borrow> borrows = bService.getAllBorrow();
        System.out.println(borrows);
    }
}
