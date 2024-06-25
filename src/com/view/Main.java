package com.view;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";  // Red color
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println();
            System.out.println("--------------------- MAIN MENU ------------------------");
            System.out.println("Choose among options:: ");
            System.out.println();
            System.out.println("1. Manage Borrows");
            System.out.println("2. Manage Members");
            System.out.println("3. Manage Books");
            System.out.println("4. Exit");
            System.out.println();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    BorrowView borrowView = new BorrowView();
                    borrowView.showMenu();
                    break;
                case 2:
                    MemberView memberView = new MemberView();
                    memberView.showMenu();
                    break;
                case 3:
                    BookView bookView = new BookView();
                    bookView.showMenu();
                    break;
                case 4:
                    System.out.println(ANSI_RED + "Exiting main program...." + ANSI_RESET);
                    break;
                default:
                    System.out.println(ANSI_RED + "Invalid choice. Please try again." + ANSI_RESET);
            }
        } while (choice != 4);

        scanner.close();
    }
}
