package com.service;

import com.model.Borrow;

import java.util.List;

public interface BorrowService {
    void addBorrow(Borrow b);
    void deleteBorrow(int id);

    List<Borrow> getAllBorrow();
}
