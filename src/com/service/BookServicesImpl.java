package com.service;

import com.model.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookServicesImpl implements BookServices {

    @Override
    public void addBook(Book b) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DatabaseUtil.getConnection();
            String sql = "insert into book (title, author, bookAvailabilityStatus) values('" + b.getTitle() + "', '" + b.getAuthor() + "', '" + b.getBookAvailabilityStatus() + "')";
            Statement stm = con.createStatement();
            stm.execute(sql);
            System.out.println("Book successfully added!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void removeBook(int id) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";  // Red color
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DatabaseUtil.getConnection();
            String sql = "delete from book where id = '"+id+"'";
            Statement stm = con.createStatement();
            stm.execute(sql);
            System.out.println(ANSI_RED+"Book removed successfully!"+ANSI_RESET);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DatabaseUtil.getConnection();
            String sql = "select * from book";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setBookAvailabilityStatus(rs.getString("bookAvailabilityStatus"));
//                System.out.println("Book ID: " + id);
//                System.out.println("Book Title: " + title);
//                System.out.println("Book Author: " + author);
//                System.out.println("Book Availability Status: " + avail);
                books.add(book);
            }

            rs.close();
            stm.close();
            con.close();

            System.out.println("All books shown successfully!");
        }catch(Exception e){
            e.printStackTrace();
        }
        return books;
    }
}
