package edu.calpoly.csc365.dao;

import edu.calpoly.csc365.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

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
    public ArrayList<Integer> getMonthBookCount() {
        Integer[] months = new Integer[13];
        Integer total = 0;
        for (int i = 0; i < 13; i++) {
            months[i] = 0;
        }
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement =
                    this.conn.prepareStatement("SELECT MONTH(checkOutDate) as mn, COUNT(*) as cnt FROM Transactions t GROUP BY MONTH(checkOutDate)");

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                months[resultSet.getInt("mn")] = resultSet.getInt("cnt");
                total += resultSet.getInt("cnt");
            }

            months[12] = total;
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
        return new ArrayList<Integer>(Arrays.asList(months));
    }

    @Override
    public Set<Book> getCheckedOutBooks(Integer userId) {
        Set<Book> books = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = this.conn.prepareStatement("SELECT DISTINCT b.author, b.title, b.asin FROM Books b JOIN Transactions t ON bookId = asin AND t.userId = ? AND t.checkedIn = 0");

            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();
            books = unpackCheckedOut(resultSet);
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
    public Set<Book> getSearchedBooks(String entry) {
        Set<Book> books = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = this.conn.prepareStatement("SELECT *, (totalQuantity - checkedOut) as stockCnt FROM " +
                    "Books JOIN Inventory ON bookId = asin WHERE title LIKE ? OR author LIKE ? OR category LIKE ? ");
            
            preparedStatement.setString(1, "%"+entry+"%");
            preparedStatement.setString(2, "%"+entry+"%");
            preparedStatement.setString(3, "%"+entry+"%");

            resultSet = preparedStatement.executeQuery();
            books = unpackSearch(resultSet);
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
        Set<Book> books = new HashSet<Book>();

        while(rs.next()) {
            Book book = new Book(
                rs.getString("asin"),
                rs.getInt("copyNum"),
                rs.getString("filename"),
                rs.getString("imageUrl"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getInt("categoryId"),
                rs.getString("category"));
            books.add(book);
        }
        return books;
    }
    private Set<Book> unpackCheckedOut(ResultSet rs) throws SQLException {
        Set<Book> books = new HashSet<Book>();

        while(rs.next()) {
            Book book = new Book(
                    rs.getString("asin"),
                    null,
                    null,
                    null,
                    rs.getString("title"),
                    rs.getString("author"),
                    null,
                    null);
            books.add(book);
        }
        return books;
    }
    private Set<Book> unpackSearch(ResultSet rs) throws SQLException {
        Set<Book> users = new HashSet<Book>();

        while(rs.next()) {
            Book book = new Book(
                    rs.getString("asin"),
                    rs.getInt("copyNum"),
                    rs.getString("filename"),
                    rs.getString("imageUrl"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getInt("categoryId"),
                    rs.getString("category"),
                    rs.getInt("stockCnt"));
            users.add(book);
        }
        return users;
    }
}