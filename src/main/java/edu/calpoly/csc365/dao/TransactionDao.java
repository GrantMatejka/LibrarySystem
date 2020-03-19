package edu.calpoly.csc365.dao;

import edu.calpoly.csc365.entity.Transaction;

public interface TransactionDao extends Dao<Transaction> {
    //Method signatures for gathering data on transactions goes here

    public void insertCheckout(String bookId, int copyNum, int userId);
    public void insertReservation(String bookId, int userId);

}
