package com.model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Borrow {
    private int id;
    private int memberId;
    private int bookId;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private double fine;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {

            this.fine = fine;

    }

    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", bookId=" + bookId +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                ", fine=Rs." + fine +
                '}'+ "\n";
    }
}
