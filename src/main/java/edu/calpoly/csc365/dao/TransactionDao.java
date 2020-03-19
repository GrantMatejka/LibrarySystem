package edu.calpoly.csc365.dao;

import edu.calpoly.csc365.entity.Transaction;

public interface TransactionDao extends Dao<Transaction> {
    public Set<Transaction> getAll();
}
