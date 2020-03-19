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
    public Book getById(String id) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Book book = null;
        try {
            preparedStatement = this.conn.prepareStatement("SELECT * FROM Books b WHERE b.asin = ?");
            preparedStatement.setString(1,id);
            resultSet = preparedStatement.executeQuery();
            System.out.println(preparedStatement);
            System.out.println(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ResultSet rs = resultSet;
            try {
                if(!rs.first()) {
                    System.out.println("empty set");                }
                else {
                    do {

                        System.out.println(rs.getString("asin"));
                        book = new Book(
                                rs.getString("asin"),
                                rs.getInt("copyNum"),
                                rs.getString("filename"),
                                rs.getString("imageUrl"),
                                rs.getString("title"),
                                rs.getString("author"),
                                rs.getInt("categoryId"),
                                rs.getString("category"));

                    }while(rs.next());
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
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

        return book;
    }

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
    public Book getById(int id) {
        return null;
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
                rs.getString("author"),
                rs.getInt("categoryId"),
                rs.getString("category"));
            users.add(book);
        }
        return users;
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