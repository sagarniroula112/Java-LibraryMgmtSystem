package com.view;

import com.model.Member;
import com.service.MemberService;
import com.service.MemberServiceImpl;

import java.util.Scanner;
import java.util.List;

public class MemberView {
    public void showMenu() {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";  // Red color
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while(!exit){
            System.out.println();
            System.out.println("--------------------- MEMBER MENU ------------------------");
            System.out.println("Choose among options:: ");
            System.out.println();
            System.out.println("1. Add a Member.");
            System.out.println("2. Show All Members.");
            System.out.println("3. Remove a Member.");
            System.out.println("4. EXIT.");
            System.out.println();
            System.out.print("Enter your choice::  ");
            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                    addMember();
                    break;

                case 2:
                    getAllMembers();
                    break;

                case 3:
                    deleteMember();
                    break;

                case 4:
                    exit = true;
                    System.out.println(ANSI_RED + "Exiting the member menu...." + ANSI_RESET);
                    break;

                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }



    }

    static void addMember() {
        MemberService mService = new MemberServiceImpl();

        char flag = 'y';
        Scanner sc = new Scanner(System.in);

        do {
            Member m = new Member();

            System.out.print("Enter member name:: ");
            m.setName(sc.nextLine());
            System.out.print("Enter member contact:: ");
            m.setContact(sc.nextLine());

            mService.addMember(m);
            System.out.println();
            System.out.print("Do you want to add more [y/n]? ");
            flag = sc.nextLine().charAt(0);
        } while (flag == 'y');
    }

    static void deleteMember() {
        MemberService mService = new MemberServiceImpl();

        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter member ID to delete:: ");
        int id = sc.nextInt();
        mService.deleteMember(id);
    }

    static void getAllMembers(){
        MemberService mService = new MemberServiceImpl();

        List<Member> members = mService.getAllMembers();
        System.out.println(members);
    }
}
