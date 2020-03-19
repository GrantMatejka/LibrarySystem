package edu.calpoly.csc365.dao;

import edu.calpoly.csc365.entity.Book;

import java.util.ArrayList;
import java.util.Set;

public interface BookDao extends Dao<Book> {
    //Method signatures for gathering data on books goes here
    public ArrayList<Integer> getMonthBookCount();
    public Set<Book> getCheckedOutBooks(Integer userId);
    public Set<Book> getSearchedBooks(String entry);
}