package com.service;

import com.model.Borrow;

import java.util.List;

public interface BorrowServices {
    void addBorrow(Borrow b);
    void removeBorrow(int id);

    List<Borrow> getAllBorrow();
}
