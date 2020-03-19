package edu.calpoly.csc365.dao;

import edu.calpoly.csc365.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class BookDaoImpl implements BookDao {

    Connection conn = null;

    public BookDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Book getById(int id) {
        return null;
    }

    @Override
    public Set<Book> getSearchedBooks(String title, String author, String category) {
        Set<Book> books = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            if(category != null) {
                preparedStatement = this.conn.prepareStatement("SELECT * FROM Books WHERE title LIKE '%%s%' " + "OR author LIKE '%%s%' OR category LIKE '%%s%'");

                preparedStatement.setString(1, title);
                preparedStatement.setString(2, author);
                preparedStatement.setString(3, category);
            } else {
                preparedStatement = this.conn.prepareStatement("SELECT * FROM Books WHERE title LIKE '%%s%' " +
                        "AND author LIKE '%%s%'");
                preparedStatement.setString(1, title);
                preparedStatement.setString(2, author);

            }
            resultSet = preparedStatement.executeQuery();
            books = unpackResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return books;
    }

    @Override
    public Set<Book> getAll() {
        Set<Book> books = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = this.conn.prepareStatement("SELECT * FROM Books");
            resultSet = preparedStatement.executeQuery();
            books = unpackResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return books;
    }

    @Override
    public Integer insert(Book obj) {
        return null;
    }

    @Override
    public Integer update(Book obj) {
        return null;
    }

    @Override
    public Integer delete(Book obj) {
        return null;
    }

    private Set<Book> unpackResultSet(ResultSet rs) throws SQLException {
        Set<Book> users = new HashSet<Book>();

        while(rs.next()) {
            Book book = new Book(
                rs.getString("asin"),
                rs.getInt("copyNum"),
                rs.getString("filename"),
                rs.getString("imageUrl"),
                rs.getString("title"),
                rs.getInt("categoryId"),
                rs.getString("category"));
            users.add(book);
            System.out.println(book);
        }
        return users;
    }
}