package com.service;

import com.model.Borrow;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class BorrowServiceImpl implements BorrowService {

    @Override
    public void addBorrow(Borrow b) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DatabaseUtil.getConnection();
            String sql = "insert into borrow (memberId, bookId, borrowDate, returnDate, fine) values('" + b.getMemberId() + "', '" + b.getBookId() + "', '" + b.getBorrowDate() + "', '" + b.getReturnDate() + "', '" + b.getFine() + "')";
            Statement stm = con.createStatement();
            stm.execute(sql);
            System.out.println("Borrow successfully added! 👍👍");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBorrow(int id) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m"; // Red color
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DatabaseUtil.getConnection();
            String sql = "delete from borrow where id = '" + id + "'";
            Statement stm = con.createStatement();
            stm.execute(sql);
            System.out.println(ANSI_RED + "Borrow removed successfully!" + ANSI_RESET);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Borrow> getAllBorrow() {
        List<Borrow> borrows = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DatabaseUtil.getConnection();
            String sql = "select * from borrow join member on borrow.memberId = member.id join book on borrow.bookId = book.id";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Borrow book = new Borrow();
                book.setId(rs.getInt("id"));
                book.setMemberId(rs.getInt("memberId"));
                book.setBookId(rs.getInt("bookId"));
                book.setBorrowDate(LocalDate.parse(rs.getString("borrowDate")));
                book.setReturnDate(LocalDate.parse(rs.getString("returnDate")));
                LocalDate returnDate = LocalDate.parse(rs.getString("returnDate"));
                if(LocalDate.now().isAfter(returnDate)){
                    long daysLate = ChronoUnit.DAYS.between(returnDate, LocalDate.now());
//                    this.fine = p.getYears() * 5;
                    book.setFine(daysLate * 5);
                }else {
                    book.setFine(rs.getDouble("fine"));
                }
                borrows.add(book);
            }

            rs.close();
            stm.close();
            con.close();

            System.out.println("All books shown successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return borrows;
    }
}
